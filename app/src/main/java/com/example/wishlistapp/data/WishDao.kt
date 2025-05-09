package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
// Abstract means it can have methods without body
abstract class WishDao {

    // Creates/Adds a Wish in wish-table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    // Fetches all wishes from the wish-table
    @Query(value = "SELECT * FROM `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query(value = "SELECT * FROM `wish-table` WHERE id = :id")
    abstract fun getWishById(id:Long): Flow<Wish>
}