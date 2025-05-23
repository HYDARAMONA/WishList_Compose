package com.example.a13wishlistapp.presentation.ui.wishListScreen.components

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    title: String,
    onBackNavClick: () -> Unit
) {

    val navBackIconButton: (@Composable () -> Unit) = {
        if (!title.contains("WishList")) {
            IconButton(onClick = onBackNavClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Button"
                )
            }
        } else {
            null
        }
    }

    TopAppBar(
        title = {
            Text(
                text = title, modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        navigationIcon = navBackIconButton,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        modifier = Modifier.clip(
            RoundedCornerShape(
                bottomStart = 16.dp,
                bottomEnd = 16.dp,
            )
        )
    )
}