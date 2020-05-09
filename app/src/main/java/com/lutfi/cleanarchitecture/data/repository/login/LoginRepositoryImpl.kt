package com.lutfi.cleanarchitecture.data.repository.login

import android.content.Context
import com.lutfi.cleanarchitecture.base.model.BaseResponse
import com.lutfi.cleanarchitecture.data.DataResult
import com.lutfi.cleanarchitecture.data.api.libs.ApiInterface
import com.lutfi.cleanarchitecture.data.api.request.Login
import com.lutfi.cleanarchitecture.data.db.dao.UserDao
import com.lutfi.cleanarchitecture.data.model.User
import com.lutfi.cleanarchitecture.util.ext.handleApiError
import com.lutfi.cleanarchitecture.util.ext.handleSuccess
import com.lutfi.cleanarchitecture.util.ext.isOnline
import com.lutfi.cleanarchitecture.util.ext.noNetworkConnectivityError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginRepositoryImpl(
    private val api: ApiInterface,
    private val context: Context,
    private val userDao: UserDao
): LoginRepository {

    override suspend fun login(username: String, password: String): DataResult<BaseResponse<User>> {
        if (isOnline(context)){
            return try {
                val response = api.login(Login(username, password))
                if (response.isSuccessful){
                    response.body()?.let {
                        withContext(Dispatchers.IO){
                            userDao.add(it.data)
                        }
                    }
                    handleSuccess(response)

                }else{
                    handleApiError(response)
                }
            }catch (e: Exception){
                DataResult.Error(e)
            }
        } else{
           return noNetworkConnectivityError()
        }
    }
}