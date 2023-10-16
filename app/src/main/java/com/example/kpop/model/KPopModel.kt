package com.example.kpop.model

import com.google.gson.annotations.SerializedName

data class KPopModel(
    var data: List<SongModel>
)

data class SongModel(
    @SerializedName("Artist")
    var artist: String,
    @SerializedName("Song Name")
    var songName: String,
    @SerializedName("Video")
    var video: String
)
