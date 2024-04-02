package com.tria.github.ui.home

import androidx.lifecycle.ViewModel
import com.tria.github.data.local.entity.UserEntity
import com.tria.github.data.repository.GithubUserRepository

class HomeViewModel(private val githubUserRepository: GithubUserRepository) : ViewModel() {
    companion object {
        private const val TAG = "HomeViewModel"
    }

    fun getInitialUser(query: String) = githubUserRepository.getInitialUser(query)

    fun searchUser(query: String) = githubUserRepository.searchUser(query)

    fun setFavoriteUser(user: UserEntity) {
        githubUserRepository.setFavoriteUser(user, true)
    }

    fun deleteFavoriteUser(user: UserEntity) {
        githubUserRepository.setFavoriteUser(user, false)
    }
}