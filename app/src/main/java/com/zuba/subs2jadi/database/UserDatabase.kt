package com.zuba.subs2jadi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FavoriteUsers::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {
    companion object {
        var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {
            if (INSTANCE==null) {
                synchronized(UserDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, "user_database").build()
                }
            }
            return  INSTANCE
        }
    }

    abstract fun favoriteUserDao(): FavoriteUsersDao
}