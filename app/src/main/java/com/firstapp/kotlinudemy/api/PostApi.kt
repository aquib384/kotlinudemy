package com.firstapp.kotlinudemy.api

import com.firstapp.kotlinudemy.model.Model
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
     fun getUser(): Call<List<Model>>?


}