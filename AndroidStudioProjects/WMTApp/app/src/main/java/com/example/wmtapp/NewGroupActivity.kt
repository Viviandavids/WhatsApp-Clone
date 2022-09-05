package com.example.wmtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.adapter.ListOfFriendsAdapter

class NewGroupActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_group)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // To set the back to home button on the New group activity
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initRecyclerview()
    }
    // Set up recyclerview and show it on the screen
    private fun initRecyclerview() {
        recyclerView = findViewById(R.id.listOfFriends)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListOfFriendsAdapter(this)

        // adding line decoration
        val decor = DividerItemDecoration(this, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(decor)
    }
}