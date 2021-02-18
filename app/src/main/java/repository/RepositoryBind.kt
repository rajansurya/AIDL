package com.society.societygate.repository

import androidx.lifecycle.LiveData
import model.SongResult
import repository.roomdatabase.ItuneDatabase
import javax.inject.Inject

class RepositoryBind @Inject constructor(
    var retrofit: RetrofitCallInterface,
    var roomDatabase: ItuneDatabase
) {
    suspend fun getItune() = retrofit.getItuneData()
    fun insertItuneData(data: SongResult) = roomDatabase.dataDao().insertData(data)
    fun getAllData(): LiveData<MutableList<SongResult>> = roomDatabase.dataDao().queryData()
}