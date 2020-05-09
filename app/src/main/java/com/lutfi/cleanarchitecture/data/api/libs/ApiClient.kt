package com.lutfi.cleanarchitecture.data.api.libs

import com.lutfi.cleanarchitecture.BuildConfig
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

class ApiClient {
    companion object {
        private const val DEFAULT_MAX_REQUEST = 30
        private const val TIMEOUT = 120

        fun create(): OkHttpClient? {
            val builder = OkHttpClient.Builder()
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)

            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
                builder.addInterceptor(interceptor).build()
            }

            val dispatcher = Dispatcher()
            dispatcher.maxRequests = DEFAULT_MAX_REQUEST
            builder.dispatcher(dispatcher)
            return builder.build()
        }

        fun create(headerInterceptor: HeaderInterceptor?): OkHttpClient? {
            val builder = OkHttpClient.Builder()
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)

            if (headerInterceptor != null) {
                builder.addInterceptor(headerInterceptor)
            }

            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                builder.addInterceptor(interceptor).build()
            }

            val dispatcher = Dispatcher()
            dispatcher.maxRequests = DEFAULT_MAX_REQUEST
            builder.dispatcher(dispatcher)
            return builder.build()
        }
    }
}