package com.example.wmtapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.wmtapp.fragment.CallFragment
import com.example.wmtapp.fragment.CameraFragment
import com.example.wmtapp.fragment.ChatFragment
import com.example.wmtapp.fragment.StatusFragment

class MainPageAdapter(fm: FragmentManager, lf: Lifecycle):FragmentStateAdapter(fm, lf) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> CameraFragment()
            1-> ChatFragment()
            2 -> StatusFragment()
            3 -> CallFragment()
            else -> ChatFragment()
        }
    }

}