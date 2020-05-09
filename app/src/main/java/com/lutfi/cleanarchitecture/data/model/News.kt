package com.lutfi.cleanarchitecture.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

@Parcelize
@Entity(tableName = "table_news")
data class News(
    @SerializedName("id")
    var newsId: Int,

    @SerializedName("category")
    var category: String,

    @SerializedName("image_url")
    var imgUrl: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("content")
    var content: String
) : Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}