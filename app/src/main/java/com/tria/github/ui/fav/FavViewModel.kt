package com.tria.github.ui.fav

import androidx.lifecycle.ViewModel
import com.tria.github.data.local.entity.UserEntity
import com.tria.github.data.repository.GithubUserRepository

class FavViewModel(private val githubUserRepository: GithubUserRepository) : ViewModel() {

    fun getFavoriteUsers() = githubUserRepository.getFavoriteUsers()

    fun setFavoriteUser(user: UserEntity) {
        githubUserRepository.setFavoriteUser(user, true)
    }

    fun deleteFavoriteUser(user: UserEntity) {
        githubUserRepository.setFavoriteUser(user, false)
    }
}