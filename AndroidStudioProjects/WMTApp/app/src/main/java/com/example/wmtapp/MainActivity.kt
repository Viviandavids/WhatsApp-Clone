package com.example.wmtapp

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

class MainActivity : AppCompatActivity() {
    private lateinit var tablayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout= findViewById(R.id.tab)

        viewPager= findViewById(R.id.viewPager)
        viewPager.adapter = MainPageAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tablayout, viewPager) {tab, position ->
             when(position) {
                0 -> tab.icon = getDrawable(R.drawable.ic_baseline_photo_camera_24)
                 1 ->tab.text = "Chats"
                2 -> tab.text = "Status"
                3 -> tab.text = "Calls"
                else -> tab.text ="Chat"
            }
        }.attach()
        viewPager.currentItem = 1
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search ->{
                Toast.makeText(this, "Search click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_group ->{
                goToNewGroupActivity()
                Toast.makeText(this, "New Group click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_broadcast->{
                goToNewBroadcastActivity()
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
    } private fun goToNewBroadcastActivity(){
        val a =Intent(this,NewBroadcastActivity::class.java)
        startActivity(a)
    }
}