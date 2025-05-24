package com.example.a13wishlistapp.presentation.ui.addEditDetailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.a13wishlistapp.R
import com.example.a13wishlistapp.data.model.Wish
import com.example.a13wishlistapp.presentation.navigation.ScreensTypes
import com.example.a13wishlistapp.presentation.ui.addEditDetailScreen.components.WishTextField
import com.example.a13wishlistapp.presentation.ui.wishListScreen.components.MyAppBar
import com.example.a13wishlistapp.presentation.viewModel.WishViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailScreen(
    id: Long,
    viewModel: WishViewModel,
    navHostController: NavHostController,
) {
    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    if (id != 0L) {
        val wish = viewModel.getWishById(id)
            .collectAsState(initial = Wish(id = 0L, title = "", description = ""))
        viewModel.wishTitleState = wish.value.title
        viewModel.wishDescriptionState = wish.value.description
    } else {
        viewModel.wishTitleState = ""
        viewModel.wishDescriptionState = ""
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
        topBar = {
            MyAppBar(
                title = if (id != 0L) stringResource(id = R.string.update_wish)
                else stringResource(id = R.string.add_wish),
                onBackNavClick = {
                    navHostController.navigateUp()
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        )
        {
            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(
                label = "Title",
                value = viewModel.wishTitleState,
                onValueChanged = {
                    viewModel.onTitleChanged(it)
                },
            )

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(
                label = "Description",
                value = viewModel.wishDescriptionState,
                onValueChanged = {
                    viewModel.onDescriptionChange(it)
                },
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    if (viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()) {
                        if (id != 0L) {
                            // UPDATE WISH
                            viewModel.updateWish(
                                Wish(
                                    id = id,
                                    title = viewModel.wishTitleState.trim(),
                                    description = viewModel.wishDescriptionState.trim()
                                )
                            )
                            snackMessage.value = "Wish Has Been Updated"
                        } else {
                            // Add Wish
                            viewModel.addWish(
                                Wish(
                                    title = viewModel.wishTitleState.trim(),
                                    description = viewModel.wishDescriptionState.trim()
                                )
                            )
                            snackMessage.value = "Wish Has Been Added"
                        }
                    } else {
                        // Show Message TO Add Wish
                        snackMessage.value = "Enter Fields to Create a Wish"
                    }
                    scope.launch {
                        val snackbarJob = launch {
                            snackBarHostState.showSnackbar(
                                message = snackMessage.value,
                                duration = SnackbarDuration.Indefinite
                            )
                        }

                        delay(1500)
                        snackBarHostState.currentSnackbarData?.dismiss()
                        snackbarJob.cancel()

                        navHostController.navigate(ScreensTypes.WishListScreen)
                    }
                },
                modifier = Modifier
                    .height(48.dp)
                    .widthIn(min = 120.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                )
            ) {
                Text(
                    text = if (id != 0L) stringResource(id = R.string.update_wish)
                    else stringResource(R.string.add_wish),
                    fontSize = 18.sp,
                )
            }

        }
    }
}