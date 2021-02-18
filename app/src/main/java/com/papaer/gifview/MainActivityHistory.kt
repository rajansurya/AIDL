package com.papaer.gifview

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivityHistory :FragmentActivity(){
    private lateinit var historyCollectionPagerAdapter: HistoryCollectionPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_main_layout)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        historyCollectionPagerAdapter= HistoryCollectionPagerAdapter(supportFragmentManager)
        viewPager=findViewById(R.id.pager)
        viewPager.adapter=historyCollectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }
}