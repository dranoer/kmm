package com.dranoer.gpt.kmm.presentation.base.ui.features.character_detail

import cafe.adriel.voyager.core.model.coroutineScope
import com.dranoer.gpt.kmm.domain.interactors.GetCharacterUseCase
import com.dranoer.gpt.kmm.domain.interactors.IsCharacterFavoriteUseCase
import com.dranoer.gpt.kmm.domain.interactors.SwitchCharacterFavoriteUseCase
import com.dranoer.gpt.kmm.presentation.base.mvi.BaseViewModel
import com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    private val getCharacterUseCase: GetCharacterUseCase,
    private val isCharacterFavoriteUseCase: IsCharacterFavoriteUseCase,
    private val switchCharacterFavoriteUseCase: SwitchCharacterFavoriteUseCase,
    private val characterId: Int,
) : com.dranoer.gpt.kmm.presentation.base.mvi.BaseViewModel<CharacterDetailContract.Event, CharacterDetailContract.State, CharacterDetailContract.Effect>() {

    init {
        getCharacter(characterId)
        checkIfIsFavorite(characterId)
    }

    override fun createInitialState(): CharacterDetailContract.State =
        CharacterDetailContract.State(
            character = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Idle,
            isFavorite = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Idle,
        )

    override fun handleEvent(event: CharacterDetailContract.Event) {
        when (event) {
            CharacterDetailContract.Event.OnFavoriteClick -> switchCharacterFavorite(characterId)
            CharacterDetailContract.Event.OnTryCheckAgainClick -> getCharacter(characterId)
            CharacterDetailContract.Event.OnBackPressed -> setEffect { CharacterDetailContract.Effect.BackNavigation }
        }
    }

    private fun getCharacter(characterId: Int) {
        setState { copy(character = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Loading) }
        coroutineScope.launch {
            getCharacterUseCase(characterId)
                .onSuccess { setState { copy(character = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Success(it)) } }
                .onFailure { setState { copy(character = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Error()) } }
        }
    }

    private fun checkIfIsFavorite(idCharacter: Int) {
        setState { copy(isFavorite = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Loading) }
        coroutineScope.launch {
            isCharacterFavoriteUseCase(idCharacter)
                .onSuccess { setState { copy(isFavorite = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Success(it)) } }
                .onFailure { setState { copy(isFavorite = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Error()) } }
        }
    }

    private fun switchCharacterFavorite(idCharacter: Int) {
        setState { copy(isFavorite = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Loading) }
        coroutineScope.launch {
            switchCharacterFavoriteUseCase(idCharacter)
                .onSuccess {
                    setState { copy(isFavorite = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Success(it)) }
                    setEffect { CharacterDetailContract.Effect.CharacterAdded }
                }.onFailure { setState { copy(isFavorite = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Error()) } }
        }
    }
}