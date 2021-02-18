package com.papaer.gifview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.society.societygate.di.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import model.SongResult
import javax.inject.Inject

class HistoryFragment : DaggerFragment() , HistoryAdapter.DatabaseCall {
    private lateinit var mRecyclerView: RecyclerView
    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var  dashborad:MainActivityModel
    lateinit var adapter:HistoryAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val view = inflater.inflate(R.layout.history_view, container, false)
        mRecyclerView =  view.findViewById(R.id.id_recyclerview)
        mRecyclerView?.layoutManager = LinearLayoutManager(activity)
        adapter=HistoryAdapter(activity as Context,this)
        mRecyclerView?.adapter=adapter
         dashborad = ViewModelProviders.of(this, factory).get(MainActivityModel::class.java)
        dashborad.getItuneData().observe(viewLifecycleOwner, Observer {
                    //println(it?.data!!.results[0].trackName)
           adapter.update(it.data!!)
        })

        var div= SpacesItemDecoration(10)//DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL)
        mRecyclerView?.addItemDecoration(div)
        dashborad.getAllData().observe(viewLifecycleOwner, Observer {
            println(it.size)
            Log.d("DDDD","it.size")
        })
        return view
    }

    override fun insertCall(songResult: SongResult) {
        try {
           var id= dashborad.insertItuneData(songResult)
            println("vehicle_lsit_item $id")
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}