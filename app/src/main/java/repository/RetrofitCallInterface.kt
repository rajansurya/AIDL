package com.society.societygate.repository

import model.SongList
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitCallInterface {
    @GET("https://itunes.apple.com/search?term=Michael+jackson&amp;media=musicVideo")
    @Headers("Content-Type: application/json")
    suspend fun getItuneData(): SongList
}