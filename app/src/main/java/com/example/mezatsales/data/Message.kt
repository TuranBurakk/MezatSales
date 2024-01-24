package com.example.mezatsales.data

data class Message(
    val userId: String? = null,
    val text: String? = null,
    val userName: String? = null)

data class MessageState(
    val item: List<Message> = emptyList()
)
