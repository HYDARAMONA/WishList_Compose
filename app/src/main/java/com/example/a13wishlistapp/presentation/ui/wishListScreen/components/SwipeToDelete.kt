package com.example.a13wishlistapp.presentation.ui.wishListScreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Custom composable to create a custom swipe to delete
@Composable
fun SwipeToDeleteContainer(
    onDelete: () -> Unit,
    animationDuration: Int = 500,
    content: @Composable () -> Unit
) {
    // To retain the state boolean that indicates if the item is removed
    var isRemoved by remember {
        mutableStateOf(value = false)
    }

    // To retain the state of the swipe to dismiss during re-composition
    var state = rememberSwipeToDismissBoxState(
        confirmValueChange = { value ->
            if (value == SwipeToDismissBoxValue.EndToStart) {
                isRemoved = true
                true
            } else {
                false
            }
        }
    )

    LaunchedEffect(key1 = isRemoved) {
        if (isRemoved) {
            // Implementation of the delete wish function from the database here//
            onDelete()
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkHorizontally(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Start,
        ) + fadeOut(),
    ) {
        SwipeToDismissBox(
            modifier = Modifier.fillMaxSize(),
            state = state,
            backgroundContent = { DeleteBackground(swipeToDismissBoxState = state) },
            content = { content() },
            // This can be modified either end to start like this or start to end
            enableDismissFromEndToStart = true,
        )
    }

}


@Composable
fun DeleteBackground(
    swipeToDismissBoxState: SwipeToDismissBoxState
) {
    val color = if (swipeToDismissBoxState.dismissDirection == SwipeToDismissBoxValue.EndToStart) {
        MaterialTheme.colorScheme.error
    } else {
        Color.Transparent
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(color = color)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            imageVector = Icons.Default.Delete, contentDescription = "Delete",
            tint = MaterialTheme.colorScheme.onError,
        )
    }
}


