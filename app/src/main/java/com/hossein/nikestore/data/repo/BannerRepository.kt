package com.hossein.nikestore.data.repo

import com.hossein.nikestore.data.Banner
import io.reactivex.Single

interface BannerRepository {
    fun getBanners(): Single<List<Banner>>
}