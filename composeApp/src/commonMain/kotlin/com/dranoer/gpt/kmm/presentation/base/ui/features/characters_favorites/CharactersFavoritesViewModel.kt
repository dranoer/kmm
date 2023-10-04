package com.dranoer.gpt.kmm.presentation.base.ui.features.characters_favorites

import cafe.adriel.voyager.core.model.coroutineScope
import com.dranoer.gpt.kmm.domain.interactors.GetCharactersFavoritesUseCase
import kotlinx.coroutines.launch

class CharactersFavoritesViewModel(
    private val getCharactersFavoritesUseCase: GetCharactersFavoritesUseCase
) : com.dranoer.gpt.kmm.presentation.base.mvi.BaseViewModel<CharactersFavoritesContract.Event, CharactersFavoritesContract.State, CharactersFavoritesContract.Effect>() {

    init {
        getCharactersFavorites()
    }

    override fun createInitialState(): CharactersFavoritesContract.State =
        CharactersFavoritesContract.State(
            charactersFavorites = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Idle
        )

    override fun handleEvent(event: CharactersFavoritesContract.Event) {
        when (event) {
            CharactersFavoritesContract.Event.OnTryCheckAgainClick -> getCharactersFavorites()
            is CharactersFavoritesContract.Event.OnCharacterClick ->
                setEffect { CharactersFavoritesContract.Effect.NavigateToDetailCharacter(event.idCharacter) }

            CharactersFavoritesContract.Event.OnBackPressed ->
                setEffect { CharactersFavoritesContract.Effect.BackNavigation }
        }
    }

    private fun getCharactersFavorites() {
        setState { copy(charactersFavorites = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Loading) }
        coroutineScope.launch {
            getCharactersFavoritesUseCase(Unit).collect {
                it.onSuccess {
                    setState {
                        copy(
                            charactersFavorites =
                            if (it.isEmpty())
                                com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Empty
                            else
                                com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Success(it)
                        )
                    }
                }.onFailure { setState { copy(charactersFavorites = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Error()) } }
            }
        }
    }
}