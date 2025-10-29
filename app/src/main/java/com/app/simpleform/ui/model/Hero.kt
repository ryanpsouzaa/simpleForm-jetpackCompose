package com.app.simpleform.ui.model

import androidx.annotation.DrawableRes

data class Hero(
    val name: String,
    val description: String,
    @DrawableRes val imageRes: Int
)