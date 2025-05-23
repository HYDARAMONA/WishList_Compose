package com.example.a13wishlistapp.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreensTypes {

    @Serializable
    data object WishListScreen

    @Serializable
    data class AddWishItem(val id: Long)
}