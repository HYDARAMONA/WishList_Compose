package com.example.a13wishlistapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a13wishlistapp.data.local.dao.WishDao
import com.example.a13wishlistapp.data.model.Wish

@Database(
    entities = [Wish::class], // Lists all database tables (entities)
    version = 1, // Database version increment on schema changes (modify DB structure)
    exportSchema = false, // Set to true if you want to export schema history (used in testing or documentation)
)
abstract class WishDataBase : RoomDatabase() {
    abstract fun wishDao(): WishDao
}