package com.ajieno.bansostracking

import com.ajieno.tisol.service.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://34.101.201.178:5001/"
    private const val BASE_URL2 = "http://35.192.75.173:5000/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }

    val instance2: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }
}