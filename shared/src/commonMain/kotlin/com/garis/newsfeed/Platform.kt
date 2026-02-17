package com.garis.newsfeed

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform