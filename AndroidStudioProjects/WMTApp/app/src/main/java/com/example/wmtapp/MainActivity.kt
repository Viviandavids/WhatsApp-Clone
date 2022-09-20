package com.example.wmtapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.viewpager2.widget.ViewPager2
import com.example.wmtapp.adapter.MainPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class MainActivity : AppCompatActivity() {
    //This is an initialization of the Toolbar
    private lateinit var toolbar: Toolbar
    //This is an initialization of the TabLayout
    private lateinit var tabLayout: TabLayout
    //This is an initialization of the ViewPager2
    private lateinit var viewPager: ViewPager2
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
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
        tabLayout = findViewById(R.id.tab)
        // This finds the ViewPager by its Id and makes it accessible
        viewPager = findViewById(R.id.viewPager)
        // To connect the ViewPager to the MainPageAdapter
        viewPager.adapter = MainPageAdapter(supportFragmentManager, lifecycle)
        // To connect the TabLayout to the ViewPager inorder to update the current fragment

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // When condition  is used to set the name option on the TabLayout  based on the position
            when (position) {
                0 -> tab.icon = AppCompatResources.getDrawable(context, R.drawable.ic_baseline_photo_camera_24)
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
}
// Note we went to the manifests folder where the new activity tag was and added two attributes;
// i label; was responsible for giving the new activity a title "New Group"
// ii parentActivityName; was responsible for returning the New group to the initial activity which was "main activity"