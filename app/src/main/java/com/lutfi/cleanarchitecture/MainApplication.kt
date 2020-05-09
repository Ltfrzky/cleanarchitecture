package com.lutfi.cleanarchitecture

import android.app.Application
import com.lutfi.cleanarchitecture.base.di.dbModule
import com.lutfi.cleanarchitecture.base.di.prefModule
import com.lutfi.cleanarchitecture.base.di.repositoryModule
import com.lutfi.cleanarchitecture.base.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // start Koin
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(dbModule, repositoryModule, uiModule, prefModule))
        }
    }
}