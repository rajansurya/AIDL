package com.papaer.gifview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.society.societygate.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import model.SongList
import model.SongResult
import javax.inject.Inject

class SinglePage :DaggerFragment(), HistoryAdapter.DatabaseCall {
    private lateinit var mRecyclerView: RecyclerView
    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var  dashborad:MainActivityModel
    lateinit  var adapter:HistoryAdapter
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        AndroidSupportInjection.inject(this)
        val view = inflater.inflate(R.layout.history_view, container, false)
        mRecyclerView =  view.findViewById(R.id.id_recyclerview)
        mRecyclerView?.layoutManager = LinearLayoutManager(activity)

        dashborad = ViewModelProviders.of(this, factory).get(MainActivityModel::class.java)

        var div= SpacesItemDecoration(10)//DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL)
        mRecyclerView?.addItemDecoration(div)
        adapter=HistoryAdapter(activity as Context,this)
        mRecyclerView?.adapter=adapter

        dashborad.getAllData().observe(viewLifecycleOwner, Observer {
          adapter.updateSingle(it)
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey("ARG_OBJECT") }?.apply {
            val textView: TextView = view.findViewById(android.R.id.text1)
            textView.text = "1"//getInt(ARG_OBJECT).toString()
        }
    }

    override fun insertCall(songResult: SongResult) {
        TODO("Not yet implemented")
    }
}