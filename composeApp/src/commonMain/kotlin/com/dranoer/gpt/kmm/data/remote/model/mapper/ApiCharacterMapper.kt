package com.dranoer.gpt.kmm.data.remote.model.mapper

import com.dranoer.gpt.kmm.data.remote.model.ApiCharacter
import com.dranoer.gpt.kmm.domain.model.Character
import com.dranoer.gpt.kmm.domain.model.Gender
import com.dranoer.gpt.kmm.domain.model.Status
import com.dranoer.gpt.kmm.domain.model.map.Mapper

class ApiCharacterMapper : Mapper<ApiCharacter, Character>() {
    override fun map(model: ApiCharacter): Character = model.run {
        Character(
            id, name, when (status) {
                "Alive" -> Status.ALIVE
                "Dead" -> Status.DEAD
                else -> Status.UNKNOWN
            }, species, when (gender) {
                "Male" -> Gender.MALE
                "Female" -> Gender.FEMALE
                "Genderless" -> Gender.GENDERLESS
                else -> Gender.UNKNOWN
            }, origin.name, location.name, image
        )
    }

    override fun inverseMap(model: Character): ApiCharacter {
        TODO("Not yet implemented")
    }
}