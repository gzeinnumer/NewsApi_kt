package com.gzeinnumer.newsapikt

import com.gzeinnumer.newsapikt.model.ResponseNewsApi
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("everything?q=bitcoin&from=2019-08-09&sortBy=publishedAt&apiKey=e5430ac2a413408aaafdf60bfa27a874")
//    fun getNews(@Query("q") q:String,
//               @Query("form") from:String,
//               @Query("sortBy") sortBy:String,
//               @Query("apiKey") apiKey:String): Call<ResponseNewsApi>
    fun getNews(): Call<ResponseNewsApi>

}