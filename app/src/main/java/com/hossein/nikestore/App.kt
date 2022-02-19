package com.hossein.nikestore

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.hossein.nikestore.data.repo.BannerRepository
import com.hossein.nikestore.data.repo.BannerRepositoryImpl
import com.hossein.nikestore.data.repo.ProductRepository
import com.hossein.nikestore.data.repo.ProductRepositoryImpl
import com.hossein.nikestore.data.repo.source.BannerRemoteDataSource
import com.hossein.nikestore.data.repo.source.ProductLocalDataSource
import com.hossein.nikestore.data.repo.source.ProductRemoteDataSource
import com.hossein.nikestore.feature.main.MainViewModel
import com.hossein.nikestore.services.FrescoImageLoadingService
import com.hossein.nikestore.services.ImageLoadingService
import com.hossein.nikestore.services.http.createApiServiceInstance
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        Fresco.initialize(this)

        val myModules = module {

            single { createApiServiceInstance() }
            single<ImageLoadingService>{FrescoImageLoadingService()}
            factory<ProductRepository> {
                ProductRepositoryImpl(
                    ProductRemoteDataSource(get()),
                    ProductLocalDataSource()
                )
            }
            factory<BannerRepository> {
                BannerRepositoryImpl(BannerRemoteDataSource(get()))
            }
            viewModel { MainViewModel(get(), get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }
    }
}