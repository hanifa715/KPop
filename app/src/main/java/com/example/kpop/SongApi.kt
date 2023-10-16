package com.example.kpop

import com.example.kpop.model.KPopModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SongApi {
    @GET("songs")
    fun getSong(
        @Query("q") songsName: String,
        @Query("by") by: String = "Song Name",
        @Header("X-RapidAPI-Key") key: String = "d0819b9839mshb3a3f2d5bd404a4p1b3f1djsnce7f51e3f7ee",
        @Header("X-RapidAPI-Host") host: String = "k-pop.p.rapidapi.com"
    ): Call<KPopModel>
}