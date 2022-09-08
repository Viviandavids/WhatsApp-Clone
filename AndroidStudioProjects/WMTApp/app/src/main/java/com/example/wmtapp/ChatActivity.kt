package com.example.wmtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.adapter.ChatsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        setupToolbar(username)
        setupChatRecyclerview(username)

        messageTyped = findViewById(R.id.message)
        sendButton = findViewById(R.id.sendButton)
        sendButton.setOnClickListener{
            val userInput: String = messageTyped.text.toString() ?: ""
            Toast.makeText(this, userInput, Toast.LENGTH_LONG).show()
        }

    }

    private fun setupChatRecyclerview(username: String) {
        messageRecyclerView = findViewById(R.id.messageSection)
        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.adapter = ChatsAdapter(this, username)


    }

    private fun setupToolbar(username: String) {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}