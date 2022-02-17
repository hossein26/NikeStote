package com.hossein.nikestore

import android.app.Application
import com.hossein.nikestore.data.repo.ProductRepository
import com.hossein.nikestore.data.repo.ProductRepositoryImpl
import com.hossein.nikestore.data.repo.source.ProductLocalDataSource
import com.hossein.nikestore.data.repo.source.ProductRemoteDataSource
import com.hossein.nikestore.feature.main.MainViewModel
import com.hossein.nikestore.services.http.createApiServiceInstance
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant()

        val myModules = module {

            single { createApiServiceInstance() }
            factory<ProductRepository> {
                ProductRepositoryImpl(
                    ProductRemoteDataSource(get()),
                    ProductLocalDataSource()
                )
            }
            viewModel { MainViewModel(get()) }
        }

        startKoin {
            androidContext(this@App)
            modules(myModules)
        }
    }
}