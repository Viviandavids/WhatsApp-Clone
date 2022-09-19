package com.example.wmtapp.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.R
import com.example.wmtapp.adapter.CallsAdapter


class CallFragment : Fragment() {
    private lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.call_menu, menu)
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
            R.id.clear_call_logs ->{
                Toast.makeText(requireContext(), "Call logs cleared", Toast.LENGTH_LONG).show()
                return  true
            }
            else -> {
                return false
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.callRV)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CallsAdapter(requireContext())
    }
}