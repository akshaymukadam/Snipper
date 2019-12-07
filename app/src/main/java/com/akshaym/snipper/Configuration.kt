package com.akshaym.snipper

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient

class Configuration internal constructor(
    context: Context,
    list: List<Interceptor>,
    monitor: Boolean,
    allowTampering: Boolean
) {


    private var clientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()


    private var isMonitoringAllowed = monitor

    private var isTamperingAllowed = allowTampering

    private lateinit var context: Context


    init {
        list.forEach {
            clientBuilder.addInterceptor(it)
        }
        clientBuilder.build()
    }


    fun getClient(): OkHttpClient = clientBuilder.build()

    class Builder(private val context: Context) {
        private val applicationInterceptor = mutableListOf<Interceptor>()

        private var isMonitoring = false

        private var tamper = false

        fun addInterceptor(list: List<Interceptor>): Builder {
            applicationInterceptor.addAll(list)
            return this
        }

        fun addInterceptor(interceptor: Interceptor): Builder {
            applicationInterceptor.add(interceptor)
            return this
        }

        fun surveillance(isAllowed: Boolean): Builder {
            isMonitoring = isAllowed
            return this
        }

        fun tamper(allowTampering: Boolean): Builder {
            tamper = allowTampering
            return this
        }

        fun build(): Configuration {
            return Configuration(context, applicationInterceptor, isMonitoring, tamper)
        }
    }
}