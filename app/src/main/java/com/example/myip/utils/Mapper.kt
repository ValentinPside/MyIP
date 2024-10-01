package com.example.myip.utils

import com.example.myip.data.IpDto
import com.example.myip.domain.Ip

fun IpDto.asIp() = Ip(
    myip = this.myip
)