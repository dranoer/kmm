package com.dranoer.gpt.kmm.repository

import com.dranoer.gpt.kmm.domain.model.Character

interface IRemoteData {
    suspend fun getCharactersFromApi(): List<Character>
    suspend fun getCharacterFromApi(id: Int): Character
}