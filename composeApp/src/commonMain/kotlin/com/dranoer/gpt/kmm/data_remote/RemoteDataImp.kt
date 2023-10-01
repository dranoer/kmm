package com.dranoer.gpt.kmm.data_remote

import com.dranoer.gpt.kmm.data_remote.model.ApiCharacter
import com.dranoer.gpt.kmm.data_remote.model.ApiCharactersResponse
import com.dranoer.gpt.kmm.data_remote.model.mapper.ApiCharacterMapper
import com.dranoer.gpt.kmm.domain.model.Character
import com.dranoer.gpt.kmm.repository.IRemoteData
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class RemoteDataImp(
    private val endPoint: String,
    private val httpClient: HttpClient,
    private val apiCharacterMapper: ApiCharacterMapper,
) : IRemoteData {
    override suspend fun getCharactersFromApi(): List<Character> =
        apiCharacterMapper.map(
            (httpClient.get("$endPoint/api/character").body<ApiCharactersResponse>()).results
        )

    override suspend fun getCharacterFromApi(id: Int): Character =
        apiCharacterMapper.map(
            httpClient.get("$endPoint/api/character/$id").body<ApiCharacter>()
        )
}