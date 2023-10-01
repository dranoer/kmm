package com.dranoer.gpt.kmm

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.dranoer.gpt.kmm.presentation.ui.theme.AppTheme
import com.dranoer.gpt.kmm.presentation.ui.features.characters.CharactersScreen

@Composable
internal fun App() = AppTheme {
    Navigator(CharactersScreen())
}

