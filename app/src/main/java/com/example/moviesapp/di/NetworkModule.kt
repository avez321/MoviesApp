package com.example.moviesapp.di

import com.example.moviesapp.network.MovieApi
import com.rtr.moviesdemo.model.MoviesClient.makeMovieApi
import org.koin.dsl.module

val networkModule = module {
    single<MovieApi> {
        makeMovieApi()
    }
}