package com.firstapp.kotlinudemy.api

import com.firstapp.kotlinudemy.Constant
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    companion object{
        fun getRetrofitClient(): Retrofit {


            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            return Retrofit.Builder().baseUrl(Constant.LIVE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
        }
    }

}