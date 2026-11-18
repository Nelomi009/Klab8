package com.example.mycity.ui

import com.example.mycity.model.Category
import com.example.mycity.model.Place

data class MyCityUiState(
    val currentCategory: Category = Category.RESTAURANT,
    val selectedPlace: Place? = null,
    val isShowingListPage: Boolean = true
)