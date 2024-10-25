package com.zuba.subs2jadi.Api

import com.zuba.subs2jadi.data.DetailUserResponse
import com.zuba.subs2jadi.data.User
import com.zuba.subs2jadi.data.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: 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")
    fun searchUser(
        @Query("q") login: String
    ): Call<UserResponse>

    @GET("users/{login}")
    @Headers("Authorization: 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")
    fun getDetailUser(
        @Path("login") login: String
    ): Call<DetailUserResponse>

    @GET("users/{login}/followers")
    @Headers("Authorization: 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")
    fun getFollowers(
        @Path("login") login: String
    ): Call<ArrayList<User>>

    @GET("users/{login}/following")
    @Headers("Authorization: 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")
    fun getFollowing(
        @Path("login") login: String
    ): Call<ArrayList<User>>

}