package com.example.a13wishlistapp.data.repository

import com.example.a13wishlistapp.data.local.dao.WishDao
import com.example.a13wishlistapp.data.model.Wish
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WishRepository @Inject constructor(
    private val wishDao: WishDao
) {

    suspend fun addWish(wish: Wish) {
        wishDao.addWish(wish)
    }

    fun getAllWishes(): Flow<List<Wish>> {
        return wishDao.getAllWishes()
    }

    fun getWishById(id: Long): Flow<Wish> {
        return wishDao.getWishById(id)
    }

    suspend fun updateWish(wish: Wish) {
        wishDao.updateWish(wish)
    }

    suspend fun deleteWish(wish: Wish) {
        wishDao.deleteWish(wish)
    }

}