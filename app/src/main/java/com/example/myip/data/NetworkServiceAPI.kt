package com.example.myip.data

import retrofit2.http.GET

interface NetworkServiceAPI {
    @GET("d4e2bt6jba6cmiekqmsv")
    suspend fun getMyIp(): IpDto
}