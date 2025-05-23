package com.example.a13wishlistapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.a13wishlistapp.presentation.ui.addEditDetailScreen.AddEditDetailScreen
import com.example.a13wishlistapp.presentation.ui.wishListScreen.WishListScreen
import com.example.a13wishlistapp.presentation.viewModel.WishViewModel


@Composable
fun AppNavHost(
    viewModel: WishViewModel = hiltViewModel(),
    navHostController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navHostController,
        startDestination = ScreensTypes.WishListScreen
    ) {

        composable<ScreensTypes.WishListScreen> {
            WishListScreen(viewModel = viewModel, navHostController = navHostController)
        }

        composable<ScreensTypes.AddWishItem> {
            val args = it.toRoute<ScreensTypes.AddWishItem>()

            AddEditDetailScreen(
                id = args.id,
                viewModel = viewModel,
                navHostController = navHostController
            )
        }

    }

}
