package com.example.usersv2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform