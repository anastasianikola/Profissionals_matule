package com.example.profissionals_matule.presentation.on_boarding

import androidx.annotation.DrawableRes
import com.example.profissionals_matule.R
import java.util.stream.IntStream.IntMapMultiConsumer


sealed class OnBoardingModel(
    @DrawableRes val image_bottom: Int,
    @DrawableRes val image_top: Int,
    val title_first: String,
    val title_second: String,
    val description: String
){
    data object  FirstPage: OnBoardingModel(
        image_bottom = R.drawable.image_1,
        image_top = 0,
        title_first = "ДОБРО\nПОЖАЛОВАТЬ",
        title_second = "",
        description = ""
    )
    data object  SecondPage: OnBoardingModel(
        image_bottom = 0,
        image_top = R.drawable.image_2,
        title_first = "",
        title_second = "Начнем\nпутешествие",
        description = "Умная, великолепная и модная\nколлекция Изучите сейчас"
    )
    data object  ThirdPage: OnBoardingModel(
        image_bottom = 0,
        image_top = R.drawable.image_3,
        title_first = "",
        title_second = "У Вас Есть Сила,\nЧтобы",
        description = "В вашей комнате много красивых и\nпривлекательных растений"
    )
}
