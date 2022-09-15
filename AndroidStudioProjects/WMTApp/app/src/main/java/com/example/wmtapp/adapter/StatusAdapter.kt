package com.example.wmtapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.R
import com.example.wmtapp.SampleStatus
import com.example.wmtapp.model.Status

class StatusAdapter(val context: Context): RecyclerView.Adapter<StatusAdapter.StatusViewHolder>() {
    val sampleStatus = SampleStatus()
    val listOfStatus: List<Status> = sampleStatus.LIST_OF_STATUS


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
     val view = LayoutInflater.from(context).inflate(R.layout.status_layout, parent, false)
        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        val theName: String = listOfStatus[position].name
        val theTime: String = listOfStatus[position].time
        holder.username.text = theName
        holder.time.text = theTime

    }

    override fun getItemCount(): Int {
        return listOfStatus.size
    }
    class StatusViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val username: TextView = itemView.findViewById(R.id.username)
        val time: TextView = itemView.findViewById(R.id.time)
    }
}