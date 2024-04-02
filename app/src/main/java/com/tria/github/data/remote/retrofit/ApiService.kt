package com.tria.github.data.remote.retrofit

import com.tria.github.data.remote.response.DetailUserResponse
import com.tria.github.data.remote.response.SearchUserResponse
import com.tria.github.data.remote.response.ItemUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    fun searchUser(@Query("q") query: String): Call<SearchUserResponse>

    @GET("users/{username}")
    fun getDetailUser(@Path("username") username: String) : Call<DetailUserResponse>

    @GET("users/{username}/followers")
    fun getFollowers(@Path("username") username: String) : Call<List<ItemUser>>

    @GET("users/{username}/following")
    fun getFollowing(@Path("username") username: String) : Call<List<ItemUser>>
}