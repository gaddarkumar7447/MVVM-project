package com.example.mvvmproject.local

import android.widget.Toast
import com.example.mvvmproject.local.responce.NumberResponce
import com.example.mvvmproject.remote.retrofit.NumberApi
import com.example.mvvmproject.util.Result
import com.example.mvvmproject.util.Status

class NumberRepo(private val numberApi: NumberApi) {
    suspend fun getNumberFact(number: Int): Result<NumberResponce> {
        return try {
            val responce = numberApi.getNumberFact("application/json", number)
            return Result(Status.SUCCESS, responce.body(), null)
        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }
    }
}