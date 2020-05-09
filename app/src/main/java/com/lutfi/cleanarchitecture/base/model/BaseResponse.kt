package com.lutfi.cleanarchitecture.base.model

import com.google.gson.annotations.SerializedName

/**
 *created by Lutfi Rizky Ramadhan on 08/05/20
 */

data class BaseResponse<Model>(
    @SerializedName("code")
    var code: Int,

    @SerializedName("data")
    var data: Model,

    @SerializedName("message")
    var message: String
)