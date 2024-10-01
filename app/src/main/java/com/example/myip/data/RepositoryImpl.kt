package com.example.myip.data

import com.example.myip.domain.Ip
import com.example.myip.domain.Repository
import com.example.myip.utils.asIp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: NetworkServiceAPI) : Repository {

    override suspend fun getMyIp(): Ip {
        return withContext(Dispatchers.IO) {
            val cardRemote = api.getMyIp()
            cardRemote.asIp()
        }
    }
}