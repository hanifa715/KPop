package com.example.kpop.view

import com.example.kpop.model.KPopModel

interface KPopView {

    fun showVideo(model:KPopModel)

    fun showError(error: String)
}