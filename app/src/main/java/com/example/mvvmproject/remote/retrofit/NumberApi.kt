package com.example.mvvmproject.remote.retrofit

import com.example.mvvmproject.local.responce.NumberResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://numbersapi.com/"
interface NumberApi {
    @GET("{number}")
    suspend fun getNumberFact(@Path("number")number: Int) : Response<NumberResponce>
}