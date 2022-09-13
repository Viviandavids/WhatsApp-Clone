package com.example.wmtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.adapter.ChatsAdapter
import com.example.wmtapp.model.Message
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageTyped: EditText
    private lateinit var sendButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Get username from the intent which starts the activity
        val username = intent.getStringExtra("USER")?: ""

        val sampleChats = SampleChats()

        // Get the chat of the specified user
        val chat: Chats? = sampleChats.getChatsOf(username)

        // get the messages of the specified user
        // We casted using the as MutableList to convert the List to MutableList
        val listOfMessages: MutableList<Message> = chat!!.messages.toMutableList()

        setupToolbar(username)
        setupChatRecyclerview(listOfMessages)

        messageTyped = findViewById(R.id.message)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener{
            // This code helps to get the user input and if no text is entered, the null check will return an empty string
            val userInput: String = messageTyped.text.toString() ?: ""

            // This simple date format is referenced to create a specific data format
            val sdf = SimpleDateFormat("h:mm a")
            val time: String = sdf.format(Date())

            // in order to update the listOfMessages above so that new message sent to the chat will appear
            // Create a message type
            val message = Message(
                sender = "me",
                time = time,
                message = userInput,
                receiver = username,
            )
            // Then add to list
            listOfMessages.add(message)
            setupChatRecyclerview(listOfMessages)

            // This function help to ensure that after a message is sent the textField is empty
            messageTyped.setText("")
        }

    }

    private fun setupChatRecyclerview(listOfMessages: List<Message>) {
        messageRecyclerView = findViewById(R.id.messageSection)
        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.adapter = ChatsAdapter(this, listOfMessages)


    }

    private fun setupToolbar(username: String) {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}