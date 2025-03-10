package com.tria.github.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tria.github.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 3)
abstract class GithubUserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: GithubUserDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): GithubUserDatabase {
            if (INSTANCE == null) {
                synchronized(GithubUserDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        GithubUserDatabase::class.java, "User.db")
                        .build()
                }
            }
            return INSTANCE as GithubUserDatabase
        }
    }
}