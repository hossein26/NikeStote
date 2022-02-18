package com.hossein.nikestore.data.repo

import com.hossein.nikestore.data.Banner
import com.hossein.nikestore.data.repo.source.BannerDataSource
import io.reactivex.Single

class BannerRepositoryImpl(val bannerRemoteDataSource: BannerDataSource): BannerRepository {
    override fun getBanners(): Single<List<Banner>> {
        return bannerRemoteDataSource.getBanners()
    }
}