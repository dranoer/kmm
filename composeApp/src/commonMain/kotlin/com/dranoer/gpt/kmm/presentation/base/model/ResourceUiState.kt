package com.dranoer.gpt.kmm.presentation.base.model

sealed interface ResourceUiState<out T> {
    data class Success<T>(val data: T) :
        com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<T>
    data class Error(val message: String? = null) :
        com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<Nothing>
    object Loading : com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<Nothing>
    object Empty : com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<Nothing>
    object Idle : com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<Nothing>
}
