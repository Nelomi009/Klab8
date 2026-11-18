package com.example.mycity.model

import androidx.annotation.DrawableRes

data class Place(
    val id: Int,
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int,
    val category: Category
)