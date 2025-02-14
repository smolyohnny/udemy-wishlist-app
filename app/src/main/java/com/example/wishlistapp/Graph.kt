package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository

// Object is type Singleton - only one can be crated, unlike class instances
object Graph {
    lateinit var database: WishDatabase

    // Doestn initialize on the start of the app, but only once it's needed. Prevents laggy boot
    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context = context, klass = WishDatabase::class.java, name = "wishlist.db").build()
    }
}