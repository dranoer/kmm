package com.dranoer.gpt.kmm.presentation.ui.features.character_detail

import com.dranoer.gpt.kmm.domain.model.Character
import com.dranoer.gpt.kmm.presentation.model.ResourceUiState
import com.dranoer.gpt.kmm.presentation.mvi.UiEffect
import com.dranoer.gpt.kmm.presentation.mvi.UiEvent
import com.dranoer.gpt.kmm.presentation.mvi.UiState

interface CharacterDetailContract {
    sealed interface Event : UiEvent {
        object OnFavoriteClick : Event
        object OnTryCheckAgainClick : Event
        object OnBackPressed : Event
    }

    data class State(
        val character: ResourceUiState<Character>,
        val isFavorite: ResourceUiState<Boolean>,
    ) : UiState

    sealed interface Effect : UiEffect {
        object CharacterAdded : Effect
        object CharacterRemoved : Effect
        object BackNavigation : Effect
    }
}