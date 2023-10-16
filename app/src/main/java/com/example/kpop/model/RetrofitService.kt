package com.example.kpop.model

import com.example.kpop.SongApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    var retrofit = Retrofit.Builder().baseUrl("https://k-pop.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    var api = retrofit.create(SongApi::class.java)
}