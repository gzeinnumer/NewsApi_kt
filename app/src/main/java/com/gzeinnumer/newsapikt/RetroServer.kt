package com.gzeinnumer.newsapikt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroServer {
//https://newsapi.org/v2/
    val URL: String= "https://newsapi.org/v2/"

    fun setInit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance():ApiService {
        return setInit().create(ApiService::class.java)
    }
}

