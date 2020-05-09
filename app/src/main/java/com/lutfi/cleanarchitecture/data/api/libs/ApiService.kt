package com.lutfi.cleanarchitecture.data.api.libs

import com.google.gson.GsonBuilder
import com.lutfi.cleanarchitecture.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

object ApiService {
    fun <S> createService(
        serviceClass: Class<S>?,
        okHttpClient: OkHttpClient?
    ): S {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient!!)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(serviceClass!!)
    }
}