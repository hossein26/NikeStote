package com.hossein.nikestore.feature.main

import androidx.lifecycle.MutableLiveData
import com.hossein.nikestore.common.NikeViewModel
import com.hossein.nikestore.data.Product
import com.hossein.nikestore.data.repo.ProductRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainViewModel(productRepository: ProductRepository): NikeViewModel() {
    val productsLiveData = MutableLiveData<List<Product>>()
    init {
        productRepository.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<Product>>{
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onSuccess(t: List<Product>) {
                    productsLiveData.value = t
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                }
            })


    }
}