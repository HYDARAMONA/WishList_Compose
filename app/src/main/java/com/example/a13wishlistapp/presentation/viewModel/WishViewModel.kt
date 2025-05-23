package com.example.a13wishlistapp.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a13wishlistapp.data.model.Wish
import com.example.a13wishlistapp.data.repository.WishRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishViewModel @Inject constructor(
    private val wishRepository: WishRepository
) : ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onTitleChanged(newValue: String) {
        wishTitleState = newValue
    }

    fun onDescriptionChange(newValue: String) {
        wishDescriptionState = newValue
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getAllWishes()
        }
    }

    fun getWishById(id: Long): Flow<Wish> {
        return wishRepository.getWishById(id)
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish = wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }

}




