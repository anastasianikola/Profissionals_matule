package com.example.profissionals_matule.presentation.home

import SearchBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissionals_matule.R
import com.example.profissionals_matule.data.models.CategoryModel
import com.example.profissionals_matule.data.models.Product
import com.example.profissionals_matule.ui.theme.Accent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val categories = listOf(
        CategoryModel(1, "Все"),
        CategoryModel(2, "Outdoor"),
        CategoryModel(3, "Tennis"),
        CategoryModel(4, "All Shoes")
    )
    val products = listOf(
        Product(1, R.drawable.image_2, "BEST SELLER","Nike Air MAX", 752.00F, favourites = false),
        Product(2, R.drawable.image_2, "BEST SELLER","Adidas Boost", 599.99F, favourites = true),
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Основной контент
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // Оставляем место для BottomAppBar
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.highlight),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                                .size(20.dp)
                        )
                        Text(
                            text = "Главная",
                            fontSize = 32.sp
                        )
                    }
                },
                navigationIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.menu),
                        contentDescription = "Menu",
                        modifier = Modifier.padding(start = 10.dp)
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            // Логика для корзины
                        }
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.basket),
                            contentDescription = "Basket"
                        )
                    }
                }
            )

            // Поиск
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar()
            }

            // Основной контент
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
            ) {
                Text(
                    text = "Категории",
                    color = com.example.profissionals_matule.ui.theme.Text,
                    fontSize = 16.sp
                )

                CategoriesRow(categories = categories) { selectedCategory ->
                    println("Выбрана категория: ${selectedCategory.name}")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Популярное",
                    color = com.example.profissionals_matule.ui.theme.Text,
                    fontSize = 16.sp
                )

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 150.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(products.size) { index ->
                        val product = products[index]
                        ProductCard(product = product) { selectedProduct ->
                            println("Выбран товар: ${selectedProduct.name}")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Акции
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Акции",
                        color = com.example.profissionals_matule.ui.theme.Text,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Все",
                        color = Accent,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable {
                            // Логика для перехода к разделу "Все"
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Изображение акций
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.frame_1000000849),
                    contentDescription = null
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(top = 10.dp)){
            BottomAppBar(
                onHomeClick = { /* Home Clicked */ },
                onFavouriteClick = { /* Favourite Clicked */ },
                onBasketClick = { /* Basket Clicked */ },
                onNotificationsClick = { /* Notifications Clicked */ },
                onProfileClick = { /* Profile Clicked */ }
            )
        }
    }
}
