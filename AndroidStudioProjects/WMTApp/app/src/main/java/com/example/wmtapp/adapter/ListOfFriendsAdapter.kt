package com.example.wmtapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.R
import com.example.wmtapp.SampleData

// This adapter class is responsible for communication between two different interfaces in this case the interfaces were (SampleData & RecyclerView),
// which ensured the replication of a particular user interface multiple times.
class ListOfFriendsAdapter(val context: Context): RecyclerView.Adapter<ListOfFriendsAdapter.LFViewHolder>(){
    // To make the components of the SampleData() class  accessible we created an instance(object) sampleData
    private val sampleData = SampleData()
    // To make the LIST_OF_FRIEND variable that was in the SampleData accessible an instance(object) of the list was created
    private val listOfFriends = sampleData.LIST_OF_FRIENDS


    // The Adapter class is an abstract class and the three functions below are expected to be over ridden.
    // This function return the item view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LFViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.list_of_friend_layout, parent, false)
        return LFViewHolder(itemView)
    }


    // This function receives an itemView and  is responsible for  making the itemView accessible and loops through the list of users provided in the SampleData()
    override fun onBindViewHolder(holder: LFViewHolder, position: Int) {
        // So for each user in the list the username and status is made available.
        holder.userName.text = listOfFriends[position].userName
        holder.status.text = listOfFriends[position].status
    }

    // This functions returns the number of times the replication of the UI(list_of_friends_layout) should occur depending on the number of users in the SampleData
    override fun getItemCount(): Int {
        return listOfFriends.size
    }

    class LFViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //To make the components of the list_of_friends_layout.xml accessible inorder to have one time reference to the UI
        val userName: TextView = itemView.findViewById(R.id.userName)
        val status: TextView = itemView.findViewById(R.id.status)
    }
}