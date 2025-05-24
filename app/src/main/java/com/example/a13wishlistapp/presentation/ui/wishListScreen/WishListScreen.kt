package com.example.a13wishlistapp.presentation.ui.wishListScreen

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.a13wishlistapp.data.model.Wish
import com.example.a13wishlistapp.presentation.navigation.ScreensTypes
import com.example.a13wishlistapp.presentation.ui.wishListScreen.components.MyAppBar
import com.example.a13wishlistapp.presentation.ui.wishListScreen.components.SwipeToDeleteContainer
import com.example.a13wishlistapp.presentation.ui.wishListScreen.components.WishItem
import com.example.a13wishlistapp.presentation.viewModel.WishViewModel

@Composable
fun WishListScreen(viewModel: WishViewModel, navHostController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            MyAppBar(
                title = "WishList",
                onBackNavClick = {}
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate(ScreensTypes.AddWishItem(id = 0L))
                },
                modifier = Modifier.padding(20.dp),
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Item")
            }
        },
    ) { innerPadding ->
        val fetchedItems = viewModel.getAllWishes.collectAsState(initial = listOf())

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(items = fetchedItems.value, key = { wish -> wish.id }) { wishItemData ->
                SwipeToDeleteContainer(
//                    item = wishItemData,
                    onDelete = { viewModel.deleteWish(wishItemData) },
                    content = {
                        WishItem(
                            wish = wishItemData,
                            onClick = {
                                val id = wishItemData.id
                                navHostController.navigate(ScreensTypes.AddWishItem(id = id))
                            }
                        )
                    }
                )
//                WishItem(wish = wishItemData, onClick = {
//                    val id = wishItemData.id
//                    navHostController.navigate(ScreensTypes.AddWishItem(id = id))
//                })
            }
        }

    }
}




