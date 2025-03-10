package com.tria.github.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "user")
@Parcelize
data class UserEntity(
    @PrimaryKey
    val login: String,

    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String? = null,

    @ColumnInfo(name = "html_url")
    val htmlUrl: String? = null,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean,

    @ColumnInfo(name = "followers")
    val followers: Int? = 0,

    @ColumnInfo(name = "following")
    val following: Int? = 0,

    @ColumnInfo(name = "name")
    val name: String? = null,
) : Parcelable
