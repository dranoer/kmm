package com.dranoer.gpt.kmm.presentation.base.ui.features.characters_favorites

import com.dranoer.gpt.kmm.domain.model.Character
import com.dranoer.gpt.kmm.presentation.base.mvi.UiEffect
import com.dranoer.gpt.kmm.presentation.base.mvi.UiEvent
import com.dranoer.gpt.kmm.presentation.base.mvi.UiState

interface CharactersFavoritesContract {
    sealed interface Event : UiEvent {
        object OnBackPressed : Event
        object OnTryCheckAgainClick : Event
        data class OnCharacterClick(val idCharacter: Int) : Event
    }

    data class State(
        val charactersFavorites: com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<List<Character>>,
    ) : UiState

    sealed interface Effect : UiEffect {
        data class NavigateToDetailCharacter(val idCharacter: Int) : Effect
        object BackNavigation : Effect

    }
}