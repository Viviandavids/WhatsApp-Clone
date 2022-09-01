package com.example.wmtapp

import com.example.wmtapp.model.Message
import com.example.wmtapp.model.User

class SampleData {
    val LIST_OF_FRIENDS: List<User> = listOf(
        User("Damola Agboola", "Hi There, I am using Whatsapp"),
        User("David Emmanuel", "Hi There, call me if it is important"),
        User("Vivian Okorie", "Hi There, I am extremely busy"),
        User("Joan Okereke", "Hi There, I am available"),
        User("Jessica ugbo", "Hi There, I am in a meeting"),
        User("Victor David", "Hi There, I am busy"),
    )
}

class SampleMessages{
    val LIST_OF_MESSAGES: List<Message> = listOf(
        Message("Vivian David", "19:00", "I am so hungry, brooo"),
        Message("Wura", "15:00", "I am so hungry brooo"),
        Message("Ayomide", "07:00", "I am so hungry brooo"),
        Message("Emmanuel", "19:00", "I am so hungry brooo"),
        Message("Eseoghene", "13:00", "I am so hungry brooo"),
        Message("Victor", "10:00", "I am so hungry brooo"),
        Message("Esther", "12:00", "I am so hungry brooo"),

    )
}