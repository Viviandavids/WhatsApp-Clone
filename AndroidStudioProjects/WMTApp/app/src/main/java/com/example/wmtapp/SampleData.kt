package com.example.wmtapp

import com.example.wmtapp.model.Chats
import com.example.wmtapp.model.Message
import com.example.wmtapp.model.Status
import com.example.wmtapp.model.User

class SampleStatus{
    val LIST_OF_STATUS: List<Status> = listOf(
        Status("Samuel Eze", "1 hour ago"),
        Status("Victor David", "2 hour ago"),
        Status("Muna udeh", "3 hour ago"),
        Status("Joan Okereke", "4 hour ago"),
        Status("Isaac popoola", "5 hour ago"),
        Status("Bright Eze", "6 hour ago"),
    )
}
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
        Message("Vivian David", "19:00", "I am so hungry, brooo", "me"),
        Message("Wura", "15:00", "I am so hungry brooo", "me"),
        Message("Ayomide", "07:00", "I am so hungry brooo", "me"),
        Message("Emmanuel", "19:00", "I am so hungry brooo", "me"),
        Message("Eseoghene", "13:00", "I am so hungry brooo", "me"),
        Message("Victor", "10:00", "I am so hungry brooo", "me"),
        Message("Esther", "12:00", "I am so hungry brooo", "me"),
    )
    fun getListOfReceivedMessages(): List<Message>{
        return LIST_OF_MESSAGES.filter { message ->
            message.sender != "me"
        }
    }
}
class SampleChats{
    val LIST_OF_CHATS: List<Chats> = listOf(
        Chats("Vivian David", listOf(
            Message("me", "12:00", "I am so hungry brooo", "Vivian David"),
            Message("Vivian David", "10:00", "I am so hungry brooo", "me"),

        )),
        Chats("Esther", listOf(
            Message("Esther", "15:00", "I am so hungry brooo", "me"),
            Message("me", "15:00", "I am so hungry brooo", "Esther"),
        ))
    )
    fun getChatsOf(username: String): Chats? {
        for (item in LIST_OF_CHATS){
            if (item.sender == username){
                return item
            }
        }
        return null
    }
}