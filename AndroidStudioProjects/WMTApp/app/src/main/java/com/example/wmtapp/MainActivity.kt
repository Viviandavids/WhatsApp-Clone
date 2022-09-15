package com.example.wmtapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.wmtapp.adapter.MainPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback

class MainActivity : AppCompatActivity() {
    //This is an initialization of the Toolbar
    private lateinit var toolbar: Toolbar
    //This is an initialization of the TabLayout
    private lateinit var tablayout: TabLayout
    //This is an initialization of the ViewPager2
    private lateinit var viewPager: ViewPager2
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        initTabLayout()
    }
     // We refactored the tabLayout with a function init
    private fun initTabLayout() {
        // This finds the TabLayout by its Id and makes it accessible
        tablayout = findViewById(R.id.tab)
        // This finds the ViewPager by its Id and makes it accessible
        viewPager = findViewById(R.id.viewPager)
        // To connect the ViewPager to the MainPageAdapter
        viewPager.adapter = MainPageAdapter(supportFragmentManager, lifecycle)
        // To connect the TabLayout to the ViewPager inorder to update the current fragment

        TabLayoutMediator(tablayout, viewPager) { tab, position ->
            // When condition  is used to set the name option on the TabLayout  based on the position
            when (position) {
                0 -> tab.icon = getDrawable(R.drawable.ic_baseline_photo_camera_24)
                1 -> tab.text = "Chats"
                2 -> tab.text = "Status"
                3 -> tab.text = "Calls"
                else -> tab.text = "Chat"
            }
        }.attach()
        // the attach function helps to attached all the fragment together
        viewPager.currentItem = 1
        //This sets the "Chat" as the Home tab.

        viewPager.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 0){
                        val intent = Intent(context, CameraActivity::class.java)
                        startActivity(intent)
                        viewPager.currentItem =1
                    }
                }
            }
        )
    }

    //This is responsible for making the menu items visible and also connects the menu page to the activity to make it visible to the user
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }
    // This enables the user to be able to click on the option menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // This acts as a filter to identify the particular menu item that was click so as to perform a specific action for each selected menu item.
        when(item.itemId){
            R.id.search ->{
                Toast.makeText(this, "Search click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_group ->{
                goToNewGroupActivity()
                // Here the function goToNewGroup is called any time the New Group menu item is selected.
                Toast.makeText(this, "New Group click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_broadcast->{
                goToNewBroadcastActivity()
                // Here the function goToNewBroadCast is called any time the New Group menu item is selected.
                Toast.makeText(this, "Broadcast Lists click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.linked_devices -> {
                Toast.makeText(this, "Linked Devices", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.starred_messages ->{
                Toast.makeText(this, "Starred Messages", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.settings -> {
                Toast.makeText(this, "settings", Toast.LENGTH_LONG).show()
                return true
            }
            else-> {
                return false
            }

        }

    } private fun goToNewGroupActivity(){
        val i = Intent(this, NewGroupActivity::class.java)
        startActivity(i)
        // The Intent makes navigation from one activity to another possible. In this casa from Main Activity to New Group Activity
        // Intent is a class so here an object "i" of the intent class was created.
        // The start or startActivity  function is called in order to achieve the navigation process

    } private fun goToNewBroadcastActivity(){
        val a =Intent(this,NewBroadcastActivity::class.java)
        startActivity(a)
        // The Intent makes navigation from one activity to another possible. In this casa from Main Activity to New BroadCast Activity
        // Intent is a class so here an object "i" of the intent class was created.
        // The start or startActivity  function is called in order to achieve the navigation process
    }
}
// Note we went to the manifests folder where the new activity tag was and added two attributes;
// i label; was responsible for giving the new activity a title "New Group"
// ii parentActivityName; was responsible for returning the New group to the initial activity which was "main activity"