package com.example.wmtapp

import com.example.wmtapp.model.Message

data class Chats(
    val sender: String,
    val messages: List<Message>,
)
