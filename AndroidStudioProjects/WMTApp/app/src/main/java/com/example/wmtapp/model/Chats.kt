package com.example.wmtapp.model

import com.example.wmtapp.model.Message

data class Chats(
    val sender: String,
    val messages: List<Message>,
)
