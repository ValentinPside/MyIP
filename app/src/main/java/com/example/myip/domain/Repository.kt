package com.example.myip.domain

interface Repository {

    suspend fun getMyIp(): Ip

}