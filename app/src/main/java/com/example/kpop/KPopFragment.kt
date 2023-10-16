package com.example.kpop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kpop.databinding.FragmentKPopBinding
import com.example.kpop.model.KPopModel
import com.example.kpop.model.RetrofitService
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KPopFragment : Fragment() {

    private lateinit var binding: FragmentKPopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKPopBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()

        lifecycle.addObserver(binding.youtubePlayerView)
    }

    private fun initClickers() {
        with(binding){
            btnSong.setOnClickListener {
                RetrofitService().api.getSong(binding.etSong.text.toString().trim()).enqueue(object : Callback<KPopModel> {
                    override fun onResponse(call: Call<KPopModel>, response: Response<KPopModel>) {
                        val model = response.body()!!.data.first()
                        val songId = response.body()?.data?.first()?.video?.replace("https://youtu.be/","")

                        tvArtistName.text = model.artist
                        tvSongName.text = model.songName

                        binding.youtubePlayerView.getYouTubePlayerWhenReady(object:YouTubePlayerCallback{
                            override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                                youTubePlayer.loadVideo(songId!!, 0f)
                            }
                        })
                    }

                    override fun onFailure(call: Call<KPopModel>, t: Throwable) {

                    }

                })
            }
        }
    }
}