package com.lutfi.cleanarchitecture.data.api.libs

import com.lutfi.cleanarchitecture.base.model.BaseResponse
import com.lutfi.cleanarchitecture.data.model.News
import retrofit2.Call
import retrofit2.http.GET

/**
 *created by Lutfi Rizky Ramadhan on 08/05/20
 */

interface ApiInterface {
    @GET("api/news")
    fun getNews(): Call<BaseResponse<List<News>>>
}