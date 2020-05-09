package com.lutfi.cleanarchitecture.base.di

import com.lutfi.cleanarchitecture.data.api.libs.ApiInterface
import com.lutfi.cleanarchitecture.data.db.AppDatabase
import com.lutfi.cleanarchitecture.data.db.dao.UserDao
import com.lutfi.cleanarchitecture.data.repository.NewsRepository
import com.lutfi.cleanarchitecture.data.viewmodel.NewsViewModel
import com.lutfi.cleanarchitecture.data.pref.AppPreference
import com.lutfi.cleanarchitecture.data.repository.login.LoginRepository
import com.lutfi.cleanarchitecture.data.repository.login.LoginRepositoryImpl
import com.lutfi.cleanarchitecture.data.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

val dbModule = module {
    single { AppDatabase.getInstance(get()) }
    factory { get<AppDatabase>().newsDao() }
}

val repositoryModule = module {
    single { NewsRepository(get()) }
//    factory { LoginRepositoryImpl(get(), androidContext(), get()) }
}

val uiModule = module {
//    factory { NewsAdapter() }
    viewModel { NewsViewModel() }
//    viewModel { LoginViewModel(get()) }
}

val prefModule = module {
    single { AppPreference(androidContext()) }
}