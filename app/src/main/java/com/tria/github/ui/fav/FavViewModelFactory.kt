package com.tria.github.ui.fav

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tria.github.data.di.Injection
import com.tria.github.data.repository.GithubUserRepository

class FavViewModelFactory private constructor(private val githubUserRepository: GithubUserRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavViewModel::class.java)) {
            return FavViewModel(githubUserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: FavViewModelFactory? = null
        fun getInstance(context: Context): FavViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: FavViewModelFactory(Injection.provideGithubRepository(context))
            }.also { instance = it }
    }

}