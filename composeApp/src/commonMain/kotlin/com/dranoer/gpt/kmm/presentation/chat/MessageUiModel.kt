package com.dranoer.gpt.kmm.presentation.chat

data class MessageUiModel(
    val type: UserType,
    val message: String,
)

sealed class UserType {
    object user : UserType()
    object gpt : UserType()
}