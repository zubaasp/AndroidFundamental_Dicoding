package com.zuba.subs2jadi.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteUsersDao {
    @Insert
    suspend fun addToFavorite(favoriteUser: FavoriteUsers)

    @Query("SELECT * FROM favorite_users")
    fun getFavoriteUser(): LiveData<List<FavoriteUsers>>

    @Query("SELECT count(*) FROM favorite_users WHERE favorite_users.id = :id")
    suspend fun checkUser(id: Int): Int

    @Query("DELETE FROM favorite_users WHERE favorite_users.id = :id")
    suspend fun removeFromFavorite(id: Int): Int
}