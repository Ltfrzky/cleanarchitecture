package com.lutfi.cleanarchitecture.data.repository.login

import com.lutfi.cleanarchitecture.base.model.BaseResponse
import com.lutfi.cleanarchitecture.data.DataResult
import com.lutfi.cleanarchitecture.data.model.User

interface LoginRepository {
    suspend fun login(username: String, password:String): DataResult<BaseResponse<User>>
}