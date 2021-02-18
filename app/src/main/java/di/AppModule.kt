package com.society.societygate.di

import android.content.Context
import androidx.room.Room
import com.society.societygate.repository.LoggingInterceptore
import com.society.societygate.repository.RetrofitCallInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import repository.roomdatabase.ItuneDatabase
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun getApiInterface(retrofit: Retrofit): RetrofitCallInterface =
        retrofit.create(RetrofitCallInterface::class.java)

    @Singleton
    @Provides
    fun getRetrofitOb(httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(httpClient)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun getHttpClient(): OkHttpClient =
        OkHttpClient().newBuilder()
            .addInterceptor(LoggingInterceptore())
            .build()

    @Singleton
    @Provides
    fun provideDatabase(context: Context): ItuneDatabase =
        Room.databaseBuilder(context, ItuneDatabase::class.java, "ITUNE")
            .fallbackToDestructiveMigration().build()


}