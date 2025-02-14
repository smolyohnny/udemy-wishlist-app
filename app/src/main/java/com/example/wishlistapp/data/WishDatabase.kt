package com.example.wishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Wish::class],
    //whenever i change tables, columns, i change the version
    version = 1,
    exportSchema = false
)
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}