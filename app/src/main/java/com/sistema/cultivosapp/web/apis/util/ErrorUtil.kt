package com.sistema.cultivosapp.web.apis.util

import android.app.Activity
import com.andrognito.flashbar.Flashbar
import com.google.gson.Gson
import com.sistema.cultivosapp.R
import retrofit2.Response

class ErrorUtil(activity: Activity) {
    private var mActivity = activity

    fun tratarError(response: Response<Any>){
        val errorBody = response.errorBody()?.string()
        if (errorBody != null){
            val bodyObj = Gson().fromJson(errorBody, CustomException::class.java)
            errorSnackBar(bodyObj.message)
        }
    }

    fun errorSnackBar(message: String) {
        Flashbar.Builder(mActivity)
            .gravity(Flashbar.Gravity.TOP)
            .duration(2000)
            .showIcon()
            .showOverlay()
            .backgroundColorRes(R.color.error)
            .message(message)
            .build()
            .show()
    }
}