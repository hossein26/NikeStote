package com.hossein.nikestore.data.repo.source

import com.hossein.nikestore.data.Banner
import io.reactivex.Single

interface BannerDataSource {
    fun getBanners(): Single<List<Banner>>
}