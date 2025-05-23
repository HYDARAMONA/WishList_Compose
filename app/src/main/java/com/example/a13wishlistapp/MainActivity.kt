package com.example.a13wishlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.a13wishlistapp.presentation.navigation.AppNavHost
import com.example.a13wishlistapp.presentation.ui.wishListScreen.WishListScreen
import com.example.a13wishlistapp.ui.theme._13WishListAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _13WishListAppTheme {

                AppNavHost()

            }
        }
    }
}

