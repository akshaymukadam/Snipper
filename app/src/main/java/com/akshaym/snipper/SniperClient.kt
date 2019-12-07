package com.akshaym.snipper

import okhttp3.OkHttpClient

object SniperClient {

    fun create(configuration: Configuration): OkHttpClient {
        return configuration.getClient()
    }
}