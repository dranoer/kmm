package com.dranoer.gpt.kmm.domain.interactors

import com.dranoer.gpt.kmm.domain.IRepository
import com.dranoer.gpt.kmm.domain.interactors.type.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher

class IsCharacterFavoriteUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Int, Boolean>(dispatcher) {
    override suspend fun block(param: Int): Boolean = repository.isCharacterFavorite(param)
}