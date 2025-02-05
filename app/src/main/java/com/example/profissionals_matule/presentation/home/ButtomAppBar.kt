package com.example.profissionals_matule.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profissionals_matule.R

@Composable
fun BottomAppBar(
    onHomeClick: () -> Unit,
    onFavouriteClick: () -> Unit,
    onBasketClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Фон для BottomAppBar
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.buttom_app_bar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )

        // Центральная кнопка (корзина)
        IconButton(
            onClick = onBasketClick,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 20.dp)
                .size(100.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.basket_2),
                contentDescription = "Basket",
            )
        }

        // Кнопки по бокам
        Row(
            modifier = Modifier
                .fillMaxWidth() // Растягиваем по ширине экрана
                .padding(horizontal = 20.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp), // Дополнительный отступ снизу
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Кнопка Home
            IconButton(
                onClick = onHomeClick,
                modifier = Modifier.weight(1f) // Растягиваем по ширине
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.home),
                    contentDescription = "Home"
                )
            }

            // Кнопка Favourites
            IconButton(
                onClick = onFavouriteClick,
                modifier = Modifier.weight(1f) // Растягиваем по ширине
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.heart_2),
                    contentDescription = "Favourites"
                )
            }

            // Пространство для центральной кнопки
            Spacer(modifier = Modifier.size(30.dp))

            // Кнопка Notifications
            IconButton(
                onClick = onNotificationsClick,
                modifier = Modifier.weight(1f) // Растягиваем по ширине
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.notification),
                    contentDescription = "Notifications"
                )
            }

            // Кнопка Profile
            IconButton(
                onClick = onProfileClick,
                modifier = Modifier.weight(1f) // Растягиваем по ширине
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.profile),
                    contentDescription = "Profile"
                )
            }
        }
    }
}

@Preview
@Composable
fun ShowBottomAppBar() {
    BottomAppBar(
        onHomeClick = { /* Home Clicked */ },
        onFavouriteClick = { /* Favourite Clicked */ },
        onBasketClick = { /* Basket Clicked */ },
        onNotificationsClick = { /* Notifications Clicked */ },
        onProfileClick = { /* Profile Clicked */ }
    )
}
