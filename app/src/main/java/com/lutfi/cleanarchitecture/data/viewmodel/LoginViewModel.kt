package com.lutfi.cleanarchitecture.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lutfi.cleanarchitecture.base.model.BaseResponse
import com.lutfi.cleanarchitecture.data.DataResult
import com.lutfi.cleanarchitecture.data.model.User
import com.lutfi.cleanarchitecture.data.repository.login.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository): ViewModel() {

    val login = MutableLiveData<DataResult<BaseResponse<User>>>()

    fun login(username: String, password: String){
        viewModelScope.launch {
            val loginResponse = repository.login(username, password)
            login.value = loginResponse
        }
    }
}