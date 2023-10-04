package com.dranoer.gpt.kmm.presentation.base.ui.features.characters

import cafe.adriel.voyager.core.model.coroutineScope
import com.dranoer.gpt.kmm.domain.interactors.GetCharactersUseCase
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
) : com.dranoer.gpt.kmm.presentation.base.mvi.BaseViewModel<CharactersContract.Event, CharactersContract.State, CharactersContract.Effect>() {

    init {
        getCharacters()
    }

    override fun createInitialState(): CharactersContract.State =
        CharactersContract.State(characters = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Idle)

    override fun handleEvent(event: CharactersContract.Event) {
        when (event) {
            CharactersContract.Event.OnTryCheckAgainClick -> getCharacters()
            is CharactersContract.Event.OnCharacterClick -> setEffect {
                CharactersContract.Effect.NavigateToDetailCharacter(
                    event.idCharacter
                )
            }

            CharactersContract.Event.OnFavoritesClick -> setEffect { CharactersContract.Effect.NavigateToFavorites }
        }
    }

    private fun getCharacters() {
        setState { copy(characters = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Loading) }
        coroutineScope.launch {
            getCharactersUseCase(Unit)
                .onSuccess {
                    setState {
                        copy(
                            characters = if (it.isEmpty())
                                com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Empty
                            else
                                com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Success(it)
                        )
                    }
                }
                .onFailure { setState { copy(characters = com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Error()) } }
        }
    }
}
