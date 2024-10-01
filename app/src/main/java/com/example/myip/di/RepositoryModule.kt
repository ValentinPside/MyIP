package com.example.myip.di

import com.example.myip.data.RepositoryImpl
import com.example.myip.domain.Repository
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {
    @Provides
    fun provideRepository(impl: RepositoryImpl): Repository = impl
}