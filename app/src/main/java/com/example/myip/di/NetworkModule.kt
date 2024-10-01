package com.example.myip.di

import com.example.myip.BuildConfig
import com.example.myip.data.NetworkServiceAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @Provides
    fun provideDefaultClient(): OkHttpClient = OkHttpClient()
        .newBuilder()
        .apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                )
            }
        }
        .build()

    @Provides
    fun provideRetrofit(defaultClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(defaultClient)
        .baseUrl("https://functions.yandexcloud.net/")
        .build()

    @Provides
    fun provideApi(retrofit: Retrofit): NetworkServiceAPI =
        retrofit.create(NetworkServiceAPI::class.java)

}