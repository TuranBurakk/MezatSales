package com.example.mezatsales.data

import android.media.Image

data class PublishedArticle(
    val articleName : String?,
    val articleDescription : String?,
    val articleTime : String,
    val articlePrice : Int,
    val articleImage : Image?,
)
