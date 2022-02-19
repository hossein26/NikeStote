package com.hossein.nikestore.services

import com.hossein.nikestore.view.NikeImageView

interface ImageLoadingService {
    fun load(imageView: NikeImageView, imageUrl: String)
}