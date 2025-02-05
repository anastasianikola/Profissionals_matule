package com.example.profissionals_matule.data.models

import android.media.Image
import androidx.annotation.DrawableRes

data class Product (
  val id: Int,
  @DrawableRes val image: Int,
  val bestSeller: String,
  val name: String,
  val price: Float,
  val favourites: Boolean
)