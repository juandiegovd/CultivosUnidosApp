package com.sistema.cultivosapp.web.models

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("userId") val userId: Long,
    @SerializedName("communityId") val communityId: Long,
    @SerializedName("communityName") var communityName: String,
    @SerializedName("role") var role: String,
    @SerializedName("userName") var userName: String,
    @SerializedName("userFirstLastName") var userFirstLastName: String,
    @SerializedName("userSecondLastName") var userSecondLastName: String
)