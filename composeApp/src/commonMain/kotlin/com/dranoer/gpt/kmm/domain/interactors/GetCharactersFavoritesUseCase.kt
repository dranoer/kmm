package com.dranoer.gpt.kmm.domain.interactors

import com.dranoer.gpt.kmm.domain.IRepository
import com.dranoer.gpt.kmm.domain.interactors.type.BaseUseCaseFlow
import com.dranoer.gpt.kmm.domain.model.Character
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetCharactersFavoritesUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCaseFlow<Unit,List<Character>>(dispatcher) {
    override suspend fun build(param: Unit): Flow<List<Character>> = repository.getCharactersFavorites()
}