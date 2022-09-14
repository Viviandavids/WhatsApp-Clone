package com.example.wmtapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.R
import com.example.wmtapp.SampleStatus
import com.example.wmtapp.model.Status

class StatusAdapter(val context: Context): RecyclerView.Adapter<StatusAdapter.StatusViewHolder>() {
    val sampleStatus = SampleStatus()
    val listOfStatus: List<Status> = sampleStatus.LIST_OF_STATUS

    class StatusViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
     val view = LayoutInflater.from(context).inflate(R.layout.status_layout, parent, false)
        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return listOfStatus.size
    }
}