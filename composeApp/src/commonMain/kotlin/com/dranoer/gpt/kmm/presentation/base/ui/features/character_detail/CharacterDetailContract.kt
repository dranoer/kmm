package com.dranoer.gpt.kmm.presentation.base.ui.features.character_detail

import com.dranoer.gpt.kmm.domain.model.Character
import com.dranoer.gpt.kmm.presentation.base.mvi.UiEffect
import com.dranoer.gpt.kmm.presentation.base.mvi.UiEvent
import com.dranoer.gpt.kmm.presentation.base.mvi.UiState

interface CharacterDetailContract {
    sealed interface Event : UiEvent {
        object OnFavoriteClick : Event
        object OnTryCheckAgainClick : Event
        object OnBackPressed : Event
    }

    data class State(
        val character: com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<Character>,
        val isFavorite: com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<Boolean>,
    ) : UiState

    sealed interface Effect : UiEffect {
        object CharacterAdded : Effect
        object CharacterRemoved : Effect
        object BackNavigation : Effect
    }
}