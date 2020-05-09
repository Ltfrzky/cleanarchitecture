package com.lutfi.cleanarchitecture.view.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lutfi.cleanarchitecture.MainApplication
import com.lutfi.cleanarchitecture.R
import com.lutfi.cleanarchitecture.base.BaseActivity
import com.lutfi.cleanarchitecture.data.DataResult
import com.lutfi.cleanarchitecture.data.viewmodel.LoginViewModel
import com.lutfi.cleanarchitecture.view.activity.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val loginViewModel: LoginViewModel by inject()

    override fun getLayoutResource(): Int {
        return R.layout.activity_login
    }

    override fun initObserver() {
        loginViewModel.login.observe(this, Observer {
            when (it) {
                is DataResult.Success -> MainActivity.start(this)
                is DataResult.Error -> {
                    Toast.makeText(this, it.exception.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun initIntent() {
//        TODO("Not yet implemented")
    }

    override fun initUI() {
//        TODO("Not yet implemented")
    }

    override fun initAction() {
        btnLogin.setOnClickListener {
            loginViewModel.login(
                tilEmail.editText!!.text.toString(),
                tilPassword.editText!!.text.toString()
            )
        }
    }

    override fun initProcess() {
//        loginViewModel.login("","")
    }
}
