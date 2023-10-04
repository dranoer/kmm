package com.dranoer.gpt.kmm.domain.repository

import com.dranoer.gpt.kmm.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface ICacheData {
    suspend fun addCharacterToFavorite(character: Character)
    suspend fun removeCharacterFromFavorite(idCharacter: Int)
    suspend fun getAllCharacterFavorites(): Flow<List<Character>>
    suspend fun isCharacterFavorite(idCharacter: Int): Boolean
}