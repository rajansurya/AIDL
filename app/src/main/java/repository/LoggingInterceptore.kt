package com.society.societygate.repository

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

class LoggingInterceptore : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val requestData = request.url()
        Log.e("Request", requestData.toString())
        val responce: Response = chain.proceed(request)
        val body: ByteArray? = responce.body()?.bytes()
        val data = String(body!!)
        Log.e("Response", data)
        return responce.newBuilder().body(ResponseBody.create(responce.body()?.contentType(), data))
            .build()
    }

}