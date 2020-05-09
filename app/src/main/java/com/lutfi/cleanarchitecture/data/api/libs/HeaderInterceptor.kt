package com.lutfi.cleanarchitecture.data.api.libs

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

class HeaderInterceptor(private val headers: HashMap<String, String>) :
    Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = mapHeaders(chain)
        return chain.proceed(request)
    }

    private fun mapHeaders(chain: Interceptor.Chain): Request {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
        for ((key, value) in headers) {
            requestBuilder.addHeader(key, value)
        }
        return requestBuilder.build()
    }

}