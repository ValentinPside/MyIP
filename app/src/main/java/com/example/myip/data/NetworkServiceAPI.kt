package com.example.myip.data

import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkServiceAPI {
    @GET("https://functions.yandexcloud.net/d4e2bt6jba6cmiekqmsv")
    suspend fun getMyIp(): IpDto
}