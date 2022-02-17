package com.hossein.nikestore.data.repo.source

import com.hossein.nikestore.data.Product
import com.hossein.nikestore.services.http.ApiService
import io.reactivex.Completable
import io.reactivex.Single

class ProductRemoteDataSource(val apiService: ApiService): ProductDataSource {
    override fun getProducts(): Single<List<Product>> {
        return apiService.getProducts()
    }

    override fun getFavoriteProducts(): Single<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun addToFavorites(): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteFromFavorites(): Completable {
        TODO("Not yet implemented")
    }
}