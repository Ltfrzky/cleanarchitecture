package com.lutfi.cleanarchitecture.data.api.libs

import com.lutfi.cleanarchitecture.base.model.BaseResponse
import com.lutfi.cleanarchitecture.data.api.request.Login
import com.lutfi.cleanarchitecture.data.model.News
import com.lutfi.cleanarchitecture.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *created by Lutfi Rizky Ramadhan on 08/05/20
 */

interface ApiInterface {
    @POST("api/login")
    fun login(@Body loginRequest: Login): Call<BaseResponse<User>>

    @GET("api/news")
    fun getNews(): Call<BaseResponse<List<News>>>
}