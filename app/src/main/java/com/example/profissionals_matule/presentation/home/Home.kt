package com.example.profissionals_matule.presentation.home

import ProductCard
import SearchBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun Home(onPopularClick: () -> Unit, onCatalogClick: () -> Unit) {
    val categories = listOf(
        CategoryModel(1, "Все"),
        CategoryModel(2, "Outdoor"),
        CategoryModel(3, "Tennis"),
        CategoryModel(4, "All Shoes")
    )
    val products = listOf(
        Product(1, R.drawable.image_2, "BEST SELLER", "Nike Air MAX", 752.00F, favourites = false),
        Product(2, R.drawable.image_2, "BEST SELLER", "Adidas Boost", 599.99F, favourites = true),
    )

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isLargeScreen = maxWidth >= 600.dp
        val topBarFontSize = if (isLargeScreen) 36.sp else 32.sp
        val categoryFontSize = if (isLargeScreen) 18.sp else 16.sp
        val gridMinCellSize = if (isLargeScreen) 180.dp else 140.dp

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                // Верхняя панель с логотипом и кнопками
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
                                    .size(if (isLargeScreen) 24.dp else 20.dp)
                            )
                            Text(
                                text = "Главная",
                                fontSize = topBarFontSize
                            )
                        }
                    },
                    navigationIcon = {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.menu),
                            contentDescription = "Menu",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(if (isLargeScreen) 32.dp else 24.dp)
                        )
                    },
                    actions = {
                        IconButton(
                            onClick = {}
                        ) {
                            Image(
                                imageVector = ImageVector.vectorResource(R.drawable.basket),
                                contentDescription = "Basket",
                                modifier = Modifier.size(if (isLargeScreen) 32.dp else 24.dp)
                            )
                        }
                    }
                )

                // Поисковая строка
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchBar()
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(if (isLargeScreen) 30.dp else 25.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "Категории",
                            color = com.example.profissionals_matule.ui.theme.Text,
                            fontSize = categoryFontSize
                        )
                        Text(
                            text = "Все",
                            color = Accent,
                            fontSize = categoryFontSize,
                            modifier = Modifier.clickable { onCatalogClick() }
                        )
                    }

                    CategoriesRow(categories = categories) { selectedCategory ->
                        println("Выбрана категория: ${selectedCategory.name}")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Популярное
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Популярное",
                            color = com.example.profissionals_matule.ui.theme.Text,
                            fontSize = categoryFontSize
                        )
                        Text(
                            text = "Все",
                            color = Accent,
                            fontSize = categoryFontSize,
                            modifier = Modifier.clickable { onPopularClick() }
                        )
                    }

                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = gridMinCellSize),
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(products) { product ->
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
                            fontSize = categoryFontSize
                        )
                        Text(
                            text = "Все",
                            color = Accent,
                            fontSize = categoryFontSize,
                            modifier = Modifier.clickable { }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Баннер с акциями
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.frame_1000000849),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // Нижняя панель навигации
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(top = 10.dp)
            ) {
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
}

