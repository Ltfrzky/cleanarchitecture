package com.lutfi.cleanarchitecture.view.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.lutfi.cleanarchitecture.R
import com.lutfi.cleanarchitecture.base.BaseActivity
import com.lutfi.cleanarchitecture.data.DataResult
import com.lutfi.cleanarchitecture.data.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val loginViewModel by viewModel<LoginViewModel>()

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initObserver() {
        loginViewModel.login.observe(this, Observer {
            when(it){
                is DataResult.Success -> Log.d("sukses", "data ${it.successData}")
                is DataResult.Error ->{
                    Toast.makeText(this, it.exception.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun initIntent() {
        TODO("Not yet implemented")
    }

    override fun initUI() {
        TODO("Not yet implemented")
    }

    override fun initAction() {
        TODO("Not yet implemented")
    }

    override fun initProcess() {
       loginViewModel.login("","")
    }
}
