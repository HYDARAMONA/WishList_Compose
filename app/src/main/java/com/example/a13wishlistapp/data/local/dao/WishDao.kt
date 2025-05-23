package com.example.a13wishlistapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.a13wishlistapp.data.model.Wish
import kotlinx.coroutines.flow.Flow


@Dao
interface WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWish(wishEntity: Wish)

    @Query("Select * from `wish-table`")
    fun getAllWishes(): Flow<List<Wish>>

    @Update
    suspend fun updateWish(wishEntity: Wish)

    @Delete
    suspend fun deleteWish(wishEntity: Wish)

    @Query("Select *from `wish-table` where id=:wishId")
    fun getWishById(wishId: Long): Flow<Wish>

}


