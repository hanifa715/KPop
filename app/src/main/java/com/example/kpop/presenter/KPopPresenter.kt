package com.example.kpop.presenter

import com.example.kpop.SongApi
import com.example.kpop.model.KPopModel
import com.example.kpop.model.RetrofitService
import com.example.kpop.view.KPopView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KPopPresenter(private val songApi: SongApi) {
    lateinit var kPopView: KPopView

    private var api = RetrofitService().api


    fun getSong(songName:String){
        songApi.getSong(songName).enqueue(object : Callback<KPopModel>{
            override fun onResponse(call: Call<KPopModel>, response: Response<KPopModel>) {

            }

            override fun onFailure(call: Call<KPopModel>, t: Throwable) {

            }

        })

    }
}