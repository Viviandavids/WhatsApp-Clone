package com.example.wmtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.adapter.ListOfFriendsAdapter

// The NewGroup is a new activity created for the menu item New Group
class NewGroupActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    // An initialization of the variable recyclerView which stated the type of value it would receive as the code progresses.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_group)
        // Instantiation of the variable recyclerView inorder to make the recyclerView accessible from the view group.

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // To set the back to home button on the New group activity
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initRecyclerview()
    }
    // Set up recyclerview and show it on the screen. We refactored it with a function.
    private fun initRecyclerview() {
        recyclerView = findViewById(R.id.listOfFriends)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // To enable the recyclerView show the next line of code.
        recyclerView.adapter = ListOfFriendsAdapter(this)
        // This is an instance of the ListOfFriendsAdapter

        // adding line decoration
        val decor = DividerItemDecoration(this, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(decor)
    }
}