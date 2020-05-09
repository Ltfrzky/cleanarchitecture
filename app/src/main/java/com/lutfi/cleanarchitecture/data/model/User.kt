package com.lutfi.cleanarchitecture.data.model

import com.google.gson.annotations.SerializedName

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

data class User(
    @SerializedName("email")
    var email: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("address")
    var address: String,

    @SerializedName("saldo")
    var saldo: Float,

    @SerializedName("token")
    var token: String
)