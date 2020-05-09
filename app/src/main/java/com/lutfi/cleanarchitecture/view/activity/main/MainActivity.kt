package com.lutfi.cleanarchitecture.view.activity.main

import android.content.Context
import android.content.Intent
import com.lutfi.cleanarchitecture.R
import com.lutfi.cleanarchitecture.base.BaseActivity
import com.lutfi.cleanarchitecture.view.activity.nfc.NfcActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object{
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initObserver() {

    }

    override fun initIntent() {
//        TODO("Not yet implemented")
    }

    override fun initUI() {
//        TODO("Not yet implemented")
    }

    override fun initAction() {
        btnNfc.setOnClickListener {
            NfcActivity.start(this)
        }
    }

    override fun initProcess() {

    }
}
