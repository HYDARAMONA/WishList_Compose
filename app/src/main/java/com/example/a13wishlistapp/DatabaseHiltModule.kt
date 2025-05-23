package com.example.a13wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.a13wishlistapp.data.local.WishDataBase
import com.example.a13wishlistapp.data.local.dao.WishDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): WishDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = WishDataBase::class.java,
            name = "wishlist.db"
        ).build()
    }


    @Provides
    fun provideUserDao(database: WishDataBase): WishDao {
        return database.wishDao()
    }
}