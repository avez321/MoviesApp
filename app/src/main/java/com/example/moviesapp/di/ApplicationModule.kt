package com.example.moviesapp.di

import com.example.moviesapp.repository.RepositoryImp
import org.koin.dsl.module

val applicationModule = module {
    single<RepositoryImp> {  RepositoryImp(get()) }
}