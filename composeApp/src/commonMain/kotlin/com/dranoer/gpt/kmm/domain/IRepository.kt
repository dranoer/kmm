package com.dranoer.gpt.kmm.domain

import com.dranoer.gpt.kmm.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface IRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getCharactersFavorites(): Flow<List<Character>>
    suspend fun getCharacter(id: Int): Character
    suspend fun addCharacterToFavorites(character: Character)
    suspend fun removeCharacterFromFavorite(idCharacter: Int)
    suspend fun isCharacterFavorite(idCharacter: Int): Boolean
}