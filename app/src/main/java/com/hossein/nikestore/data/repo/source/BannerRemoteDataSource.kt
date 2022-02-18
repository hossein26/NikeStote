package com.hossein.nikestore.data.repo.source

import com.hossein.nikestore.data.Banner
import com.hossein.nikestore.services.http.ApiService
import io.reactivex.Single

class BannerRemoteDataSource(val apiService: ApiService): BannerDataSource {
    override fun getBanners(): Single<List<Banner>> {
        return apiService.getBanners()
    }
}