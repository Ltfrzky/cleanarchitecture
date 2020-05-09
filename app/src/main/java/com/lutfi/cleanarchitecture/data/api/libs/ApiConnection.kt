package com.lutfi.cleanarchitecture.data.api.libs

import com.lutfi.cleanarchitecture.base.model.BaseResponse
import com.lutfi.cleanarchitecture.data.api.request.Login
import com.lutfi.cleanarchitecture.data.model.News
import com.lutfi.cleanarchitecture.data.model.User
import retrofit2.Call
import retrofit2.Response
import java.util.*

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

class ApiConnection {
    companion object {
        private fun provideHeader(token: String): HeaderInterceptor? {
            val headers = HashMap<String, String>()
            headers["Authorization"] = token
            return HeaderInterceptor(headers)
        }

        private suspend fun login(loginRequest: Login): Response<BaseResponse<User>> {
            return ApiService.createService(
                ApiInterface::class.java,
                ApiClient.create()
            ).login(loginRequest)
        }

        private fun getNews(token: String): Call<BaseResponse<List<News>>> {
            return ApiService.createService(
                ApiInterface::class.java,
                ApiClient.create(provideHeader(token))
            ).getNews()
        }
    }
}