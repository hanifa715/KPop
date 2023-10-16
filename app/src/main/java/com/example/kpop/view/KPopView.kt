package com.example.kpop.view

import com.example.kpop.model.KPopModel

interface KPopView {

    fun setVideo(model:KPopModel)

    fun showError(error: String)
}