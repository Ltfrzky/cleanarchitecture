package com.lutfi.cleanarchitecture.util.ext

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import com.lutfi.cleanarchitecture.data.DataResult
import com.lutfi.cleanarchitecture.util.ApiErrorUtils
import retrofit2.Response

fun isOnline(context: Context): Boolean {
    var result = false
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connectivityManager?.run {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
                    else -> false
                }
            }
        }
    } else {
        connectivityManager?.run {
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            return activeNetwork?.isConnected == true
        }
    }
    return result
}

fun <T : Any> handleApiError(resp: Response<T>): DataResult.Error {
    val error = ApiErrorUtils.parseError(resp)
    return DataResult.Error(Exception(error.message))
}

fun <T : Any> handleSuccess(response: Response<T>): DataResult<T> {
    response.body()?.let {
        return DataResult.Success(it)
    } ?: return handleApiError(response)
}

fun noNetworkConnectivityError(): DataResult.Error {
    return DataResult.Error(Exception("No Internet"))
}