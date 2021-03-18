package com.example.moviesapp

import androidx.multidex.MultiDexApplication
import com.example.moviesapp.di.applicationModule
import com.example.moviesapp.di.networkModule
import com.example.moviesapp.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MoviesApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MoviesApp)
            androidFileProperties()
            modules(listOf(applicationModule, viewmodelModule, networkModule))
        }
    }

}