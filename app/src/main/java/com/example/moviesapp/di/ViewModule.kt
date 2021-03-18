package com.example.moviesapp.di

import com.example.moviesapp.ui.popular_movies.PopularMoviesViewModel
import com.example.moviesapp.ui.login.LoginViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { PopularMoviesViewModel(androidApplication()) }

    viewModel { LoginViewModel(androidApplication()) }
}