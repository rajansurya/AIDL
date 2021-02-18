package com.papaer.gifview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import model.SongList
import model.SongResult


public class HistoryAdapter(val context: Context, val datacall: DatabaseCall) : RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {
    lateinit var alldata: SongList

    fun update(alldatal: SongList) {
        this.alldata = alldatal
        notifyDataSetChanged()
    }
    fun updateSingle(ob: MutableList<SongResult>) {
        if (::alldata.isInitialized) {
            this.alldata.results.clear()
            this.alldata.results.addAll(ob)
            notifyDataSetChanged()
        } else {
            val oo = SongList(1, ob)
            this.alldata = oo
            notifyDataSetChanged()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        if (::alldata.isInitialized) {
            return alldata.results.size
        } else {
            return 0
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(alldata.results.get(position).artworkUrl100).into(holder.ImageButton)
        holder.ImageButton.setOnClickListener {
            datacall.insertCall(alldata.results.get(position))
            val intent = Intent(context, FullView::class.java)
            intent.putExtra("alldata", alldata.results.get(position))
            context.startActivity(intent)
        }
    }

    interface DatabaseCall {
        fun insertCall(songResult: SongResult)
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ImageButton: ImageView

        init {
            ImageButton = view.findViewById(R.id.mButton) as ImageView
        }
    }
}