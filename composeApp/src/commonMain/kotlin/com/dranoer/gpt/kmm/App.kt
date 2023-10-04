package com.dranoer.gpt.kmm

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.dranoer.gpt.kmm.presentation.base.ui.features.characters.CharactersScreen
import com.dranoer.gpt.kmm.presentation.base.ui.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    Navigator(CharactersScreen())
}

