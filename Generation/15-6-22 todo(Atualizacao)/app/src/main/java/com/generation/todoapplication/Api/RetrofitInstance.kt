package com.generation.todoapplication.Api

import android.provider.SyncStateContract
import com.generation.todoapplication.util.Constants
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}