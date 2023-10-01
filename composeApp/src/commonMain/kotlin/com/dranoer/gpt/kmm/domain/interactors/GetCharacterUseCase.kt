package com.dranoer.gpt.kmm.domain.interactors

import com.dranoer.gpt.kmm.domain.IRepository
import com.dranoer.gpt.kmm.domain.interactors.type.BaseUseCase
import com.dranoer.gpt.kmm.domain.model.Character
import kotlinx.coroutines.CoroutineDispatcher

class GetCharacterUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Int, Character>(dispatcher){
    override suspend fun block(param: Int): Character = repository.getCharacter(param)
}