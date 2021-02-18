package com.papaer.gifview

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HistoryCollectionPagerAdapter(fm:FragmentManager) :FragmentPagerAdapter(fm){
    override fun getPageTitle(position: Int): CharSequence? {
        return if (position==0)return "SongList" else return "History"
    }
    override fun getItem(position: Int): Fragment {
        if (position==1) {
            val fragment = SinglePage()
            fragment.arguments = Bundle().apply {
                putInt("position", position)
            }
            return fragment
        }else{
            val fragment = HistoryFragment()
            fragment.arguments = Bundle().apply {
                putInt("position", position)
            }
            return fragment
        }
    }

    override fun getCount(): Int =2

}