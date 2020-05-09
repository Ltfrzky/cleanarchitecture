package com.lutfi.cleanarchitecture.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lutfi.cleanarchitecture.data.model.News
import com.lutfi.cleanarchitecture.data.db.dao.NewsDao
import com.lutfi.cleanarchitecture.util.AppConstant

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

@Database(entities = [News::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, AppConstant.DB_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }
}