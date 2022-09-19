package com.example.wmtapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wmtapp.NewBroadcastActivity
import com.example.wmtapp.NewGroupActivity
import com.example.wmtapp.R
import com.example.wmtapp.adapter.ListOfMessagesAdapter


class ChatFragment : Fragment() {
private lateinit var chatRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Declaration that this fragment will contain a menu
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chatRecycler = view.findViewById(R.id.chatRecycler)

        chatRecycler.adapter = ListOfMessagesAdapter(requireContext())
        chatRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

    //This is responsible for making the menu items visible and also connects the menu page to the activity to make it visible to the user
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)

    }

    // This enables the user to be able to click on the option menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // This acts as a filter to identify the particular menu item that was click so as to perform a specific action for each selected menu item.
        when(item.itemId){
            R.id.search ->{
                Toast.makeText(requireContext(), "Search click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_group ->{
                goToNewGroupActivity()
                // Here the function goToNewGroup is called any time the New Group menu item is selected.
                Toast.makeText(requireContext(), "New Group click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_broadcast->{
                goToNewBroadcastActivity()
                // Here the function goToNewBroadCast is called any time the New Group menu item is selected.
                Toast.makeText(requireContext(), "Broadcast Lists click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.linked_devices -> {
                Toast.makeText(requireContext(), "Linked Devices", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.starred_messages ->{
                Toast.makeText(requireContext(), "Starred Messages", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.settings -> {
                Toast.makeText(requireContext(), "settings", Toast.LENGTH_LONG).show()
                return true
            }
            else-> {
                return false
            }

        }

    } private fun goToNewGroupActivity(){
        val i = Intent(requireContext(), NewGroupActivity::class.java)
        startActivity(i)
        // The Intent makes navigation from one activity to another possible. In this casa from Main Activity to New Group Activity
        // Intent is a class so here an object "i" of the intent class was created.
        // The start or startActivity  function is called in order to achieve the navigation process

    } private fun goToNewBroadcastActivity(){
        val a = Intent(requireContext(), NewBroadcastActivity::class.java)
        startActivity(a)
        // The Intent makes navigation from one activity to another possible. In this casa from Main Activity to New BroadCast Activity
        // Intent is a class so here an object "i" of the intent class was created.
        // The start or startActivity  function is called in order to achieve the navigation process
    }

}