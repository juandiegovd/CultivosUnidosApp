package com.sistema.cultivosapp.web.apis.requests

import com.google.gson.annotations.SerializedName

data class UserLoginRequest (
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String
)