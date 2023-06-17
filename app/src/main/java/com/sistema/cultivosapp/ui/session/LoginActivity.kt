package com.sistema.cultivosapp.ui.session

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sistema.cultivosapp.MainActivity
import com.sistema.cultivosapp.databinding.ActivityLoginBinding
import com.sistema.cultivosapp.web.adapters.session.UserAdapter

class LoginActivity: AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val btnIngresar: Button = mBinding.btnIngresar
        btnIngresar.setOnClickListener {
            val txtUsr = mBinding.edtUser.text.toString()
            val txtPwd = mBinding.edtPassword.text.toString()

            val userAdapter = UserAdapter(this)
            userAdapter.login(txtUsr, txtPwd){
                if (it?.userId != null){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}