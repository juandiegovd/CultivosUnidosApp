package com.sistema.cultivosapp.web.apis.util

import com.google.gson.annotations.SerializedName

data class CustomException(
    @SerializedName("username") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: Any
)