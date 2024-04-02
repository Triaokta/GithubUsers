package com.tria.github.data.di

import android.content.Context
import com.tria.github.data.repository.DetailUserRepository
import com.tria.github.data.repository.GithubUserRepository
import com.tria.github.data.local.room.GithubUserDatabase
import com.tria.github.data.preferences.SettingPreferences
import com.tria.github.data.remote.retrofit.ApiConfig
import com.tria.github.utils.AppExecutors

object Injection {
    fun provideGithubRepository(context: Context): GithubUserRepository {
        val apiService = ApiConfig.getApiService(context)
        val database = GithubUserDatabase.getInstance(context)
        val dao = database.userDao()
        val appExecutors = AppExecutors()
        return GithubUserRepository.getInstance(apiService, dao, appExecutors)
    }

    fun provideDetailRepository(context: Context): DetailUserRepository {
        val apiService = ApiConfig.getApiService(context)
        val database = GithubUserDatabase.getInstance(context)
        val dao = database.userDao()
        val appExecutors = AppExecutors()
        return DetailUserRepository.getInstance(apiService, dao, appExecutors)
    }

    fun provideSettingPreferences(context: Context): SettingPreferences {
        return SettingPreferences.getInstance(context)
    }
}