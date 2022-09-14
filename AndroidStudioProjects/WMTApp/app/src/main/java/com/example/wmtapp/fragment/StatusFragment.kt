package com.example.wmtapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.R
import com.example.wmtapp.adapter.StatusAdapter


class StatusFragment : Fragment() {
    private lateinit var statusRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        statusRecyclerView = view.findViewById(R.id.statusRV)
        statusRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        statusRecyclerView.adapter = StatusAdapter(requireContext())
    }

}