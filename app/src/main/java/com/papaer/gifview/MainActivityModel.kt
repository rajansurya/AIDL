package com.papaer.gifview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bumptech.glide.Glide
import com.society.societygate.repository.RepositoryBind
import com.society.societygate.repository.Resource
import kotlinx.coroutines.Dispatchers
import model.SongResult
import javax.inject.Inject
import kotlin.concurrent.thread

class MainActivityModel @Inject constructor(var repository: RepositoryBind) : ViewModel() {

    fun getItuneData() = liveData(Dispatchers.IO) {
        try {
            val data = repository.getItune()
            emit(Resource.success(data))
        } catch (e: Exception) {
            emit(Resource.error(null, e.printStackTrace().toString()))

        }
    }

    fun insertItuneData(data: SongResult) = thread {
        var id = repository.insertItuneData(data)
        println("jjjjjj $id")
    }


    fun getAllData() = repository.getAllData()
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view)
            .load(url)
            .into(view)
    }
}