package com.example.wmtapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.CameraActivity
import com.example.wmtapp.NewGroupActivity
import com.example.wmtapp.R
import com.example.wmtapp.adapter.StatusAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class StatusFragment : Fragment() {
    private lateinit var statusRecyclerView: RecyclerView
    private lateinit var cameraBtn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerview(view)

        // setup the camera button
        cameraBtn = view.findViewById(R.id.CameraBtn)
        cameraBtn.setOnClickListener {
            val intent = Intent(requireContext(), CameraActivity::class.java)
            requireContext().startActivity(intent)
        }
    }

    private fun initRecyclerview(view: View) {
        statusRecyclerView = view.findViewById(R.id.statusRV)
        statusRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        statusRecyclerView.adapter = StatusAdapter(requireContext())
    }

    // Create menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.status_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {
                Toast.makeText(requireContext(), "Search click", Toast.LENGTH_LONG).show()
                return  true
            }
            R.id.settings -> {
                Toast.makeText(requireContext(), "Settings", Toast.LENGTH_LONG).show()
                return  true
            }
            R.id.status_privacy ->{
            Toast.makeText(requireContext(), "Status Privacy", Toast.LENGTH_LONG).show()
                return  true
            }
            else -> {
                return false
            }

        }
    }
}