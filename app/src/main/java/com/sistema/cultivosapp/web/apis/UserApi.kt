package com.sistema.cultivosapp.web.apis

import com.sistema.cultivosapp.web.apis.requests.UserLoginRequest
import com.sistema.cultivosapp.web.models.UserDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserApi {

    @Headers("Content-Type: application/json")
    @POST("/user/login")
    fun login(@Body user: UserLoginRequest): Call<UserDTO>
}