package com.example.mvvmproject.hilt

import com.example.mvvmproject.remote.retrofit.BASE_URL
import com.example.mvvmproject.remote.retrofit.NumberApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(Singleton::class)
@Module
object NumberModule {

    @Provides
    @Singleton
    fun provideRetrofitInterfaces() : NumberApi{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(NumberApi::class.java)
    }
}