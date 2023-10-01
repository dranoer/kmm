package com.dranoer.gpt.kmm.presentation.ui.features.characters

import com.dranoer.gpt.kmm.domain.model.Character
import com.dranoer.gpt.kmm.presentation.model.ResourceUiState
import com.dranoer.gpt.kmm.presentation.mvi.UiEffect
import com.dranoer.gpt.kmm.presentation.mvi.UiEvent
import com.dranoer.gpt.kmm.presentation.mvi.UiState

interface CharactersContract {
    sealed interface Event : UiEvent {
        object OnTryCheckAgainClick : Event
        object OnFavoritesClick : Event
        data class OnCharacterClick(val idCharacter: Int) : Event
    }

    data class State(
        val characters: ResourceUiState<List<Character>>
    ) : UiState

    sealed interface Effect : UiEffect {
        data class NavigateToDetailCharacter(val idCharacter: Int) : Effect
        object NavigateToFavorites : Effect
    }
}


