package com.lutfi.cleanarchitecture.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lutfi.cleanarchitecture.data.model.News

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

@Dao
interface NewsDao {
    @Insert
    fun insertNews(news: News)

    @Query("SELECT * FROM table_news")
    fun getAllNews(): LiveData<List<News>>

    @Query("SELECT * FROM table_news WHERE newsId IS :newsId")
    fun getNews(newsId: Int): News?
}