package com.example.profissionals_matule.presentation.popular

import ProductCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissionals_matule.R
import com.example.profissionals_matule.data.models.Product

@Composable
fun Popular(onHomeClick: () -> Unit, onFavouriteClick: () -> Unit) {
    val products = listOf(
        Product(1, R.drawable.image_2, "BEST SELLER", "Nike Air MAX", 752.00F, favourites = false),
        Product(2, R.drawable.image_2, "BEST SELLER", "Adidas Boost", 599.99F, favourites = true),
    )

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val maxWidth = maxWidth

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { onHomeClick() }
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier.size(44.dp)
                    )
                }
                Text(
                    text = "Популярное",
                    fontSize = 16.sp,
                    color = com.example.profissionals_matule.ui.theme.Text
                )
                IconButton(
                    onClick = { onFavouriteClick() }
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.heart),
                        contentDescription = null,
                        modifier = Modifier.size(44.dp)
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = if (maxWidth < 600.dp) 140.dp else 180.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(products.size) { index ->
                    val product = products[index]
                    ProductCard(product = product) { selectedProduct ->
                        println("Выбран товар: ${selectedProduct.name}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPopular() {
    Popular(onHomeClick = {}, onFavouriteClick = {})
}