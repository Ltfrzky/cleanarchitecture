package com.lutfi.cleanarchitecture.data

sealed class DataResult<out T> {

    data class Success<out T>(val successData : T) : DataResult<T>()

    class Error(val exception: Exception, val message: String = exception.localizedMessage)
        : DataResult<Nothing>()
}
