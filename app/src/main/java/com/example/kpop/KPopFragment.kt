package com.example.kpop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kpop.databinding.FragmentKPopBinding
import com.example.kpop.model.KPopModel
import com.example.kpop.presenter.KPopPresenter
import com.example.kpop.view.KPopView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback


class KPopFragment : Fragment(),KPopView {

    private lateinit var binding: FragmentKPopBinding

    private var presenter = KPopPresenter(this)

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
        binding.btnSong.setOnClickListener {
            presenter.getSong(binding.etSong.text.toString().trim())
        }

    }

    override fun setVideo(model: KPopModel) {
        binding.youtubePlayerView.getYouTubePlayerWhenReady(object:YouTubePlayerCallback{
            override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                val songId = model.data.first().video.replace("https://youtu.be/","")
                youTubePlayer.loadVideo(songId, 0f)
            }
        })
        binding.tvArtistName.text = model.data.first().artist
        binding.tvSongName.text = model.data.first().songName
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
}