package com.dranoer.gpt.kmm.presentation.base.ui.common.state

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState

@Composable
fun <T> ManagementResourceUiState(
    modifier: Modifier = Modifier,
    resourceUiState: com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState<T>,
    successView: @Composable (data: T) -> Unit,
    loadingView: @Composable () -> Unit = { Loading() },
    onTryAgain: () -> Unit,
    msgTryAgain: String = "No data to show",
    onCheckAgain: () -> Unit,
    msgCheckAgain: String = "An error has occurred"
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        when (resourceUiState) {
            is com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Empty -> Empty(modifier = modifier, onCheckAgain = onCheckAgain, msg = msgCheckAgain)
            is com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Error -> Error(modifier = modifier, onTryAgain = onTryAgain, msg = msgTryAgain)
            com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Loading -> loadingView()
            is com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Success -> successView(resourceUiState.data)
            com.dranoer.gpt.kmm.presentation.base.model.ResourceUiState.Idle -> Unit
        }
    }
}