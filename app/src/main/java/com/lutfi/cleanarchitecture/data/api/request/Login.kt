package com.lutfi.cleanarchitecture.data.api.request

import com.google.gson.annotations.SerializedName

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

data class Login(
    @SerializedName("email")
    var username: String,

    @SerializedName("password")
    var password: String
)