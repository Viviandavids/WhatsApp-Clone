package com.example.wmtapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.adapter.ListOfFriendsAdapter

class NewBroadcastActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_broadcast)

        recyclerView = findViewById(R.id.listOfFriends)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListOfFriendsAdapter(this)

        //adding line decoration
        val decor = DividerItemDecoration(this, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(decor)
}

}