package com.sistema.cultivosapp.web.adapters.session

import android.app.Activity
import com.sistema.cultivosapp.web.adapters.ServiceBuilder
import com.sistema.cultivosapp.web.apis.UserApi
import com.sistema.cultivosapp.web.apis.requests.UserLoginRequest
import com.sistema.cultivosapp.web.apis.util.ErrorUtil
import com.sistema.cultivosapp.web.models.UserDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserAdapter(activity: Activity) {

    private var mActivity = activity

    fun login(user: String, pwd: String, onResult: (UserDTO?) -> Unit){
        val userReq = UserLoginRequest(user, pwd)
        val retrofit = ServiceBuilder.buildService(UserApi::class.java)
        retrofit.login(userReq).enqueue(
            object: Callback<UserDTO>{
                override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<UserDTO>, response: Response<UserDTO>) {
                    if (response.isSuccessful){
                        val userDTO = response.body()
                        onResult(userDTO)
                    }
                    else{
                        ErrorUtil(mActivity).tratarError(response as Response<Any>)
                    }
                }
            }
        )
    }
}