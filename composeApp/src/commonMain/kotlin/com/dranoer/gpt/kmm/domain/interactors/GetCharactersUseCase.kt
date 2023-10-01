package com.dranoer.gpt.kmm.domain.interactors

import com.dranoer.gpt.kmm.domain.IRepository
import com.dranoer.gpt.kmm.domain.interactors.type.BaseUseCase
import com.dranoer.gpt.kmm.domain.model.Character
import kotlinx.coroutines.CoroutineDispatcher

class GetCharactersUseCase(
    private val repository: IRepository,
    dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, List<Character>>(dispatcher){
    override suspend fun block(param: Unit): List<Character> = repository.getCharacters()
}