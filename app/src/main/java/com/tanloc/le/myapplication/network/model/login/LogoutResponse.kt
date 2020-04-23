package com.tanloc.le.myapplication.network.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LogoutResponse internal constructor(
    @Expose
    @SerializedName("status_code")
    private var statusCode: String? = null,
    @Expose
    @SerializedName("message")
    private var message: String? = null
)