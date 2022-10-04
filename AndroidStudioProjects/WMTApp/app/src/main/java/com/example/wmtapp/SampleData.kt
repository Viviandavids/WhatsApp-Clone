package com.example.wmtapp

import com.example.wmtapp.model.*

class SampleCalls{
    val LIST_OF_CALLS: MutableList<CallsModel> = mutableListOf(
            CallsModel("Joan Okereke", "September 12,12:11" ),
            CallsModel("Anthony umeh", "September 12,12:11" ),
            CallsModel("Esther David", "September 13,12:11" ),
            CallsModel("Victor Eze", "September 14,12:11" ),
            CallsModel("Ezinne udeh", "September 15,12:11" ),

    )
}
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
        Message("Vivian David", "19:00", "I am so hungry, brooo", "me", R.drawable.avatar_2),
        Message("Wura", "15:00", "How are you doing", "me", R.drawable.avatar_3),
        Message("Ayomide", "07:00", "I sent you some files", "me", R.drawable.avatar_4),
        Message("Emmanuel", "19:00", "What time will you be around", "me", R.drawable.avatar_5),
        Message("Eseoghene", "13:00", "How is your day going", "me", R.drawable.avatar_3),
        Message("Victor", "10:00", "Come to the store later", "me", R.drawable.avatar_6),
        Message("Esther", "12:00", "Stop by at the market when coming home", "me", R.drawable.avatar_7),
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
            Message("me", "12:00", "I am so hungry brooo", "Vivian David", R.drawable.avatar_2),
            Message("Vivian David", "10:00", "I am so hungry brooo", "me", R.drawable.avatar_3),

        )),
        Chats("Esther", listOf(
            Message("Esther", "15:00", "I am so hungry brooo", "me", R.drawable.avatar_7),
            Message("me", "15:00", "I am so hungry brooo", "Esther", R.drawable.avatar_2),
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