package com.papaer.gifview

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.papaer.gifview.databinding.FullViewBinding
import model.SongResult

class FullView : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:FullViewBinding= DataBindingUtil.setContentView(this,R.layout.full_view)
        val urlimg=intent.getParcelableExtra("alldata") as SongResult
          binding.data=urlimg
    }
}