package com.example.profissionals_matule.presentation.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissionals_matule.R
import com.example.profissionals_matule.data.models.Product
import com.example.profissionals_matule.ui.theme.Accent
import com.example.profissionals_matule.ui.theme.Hint
import com.example.profissionals_matule.ui.theme.Red

@Composable
fun ProductCard(product: Product, onProductClick: (Product) -> Unit = {}) {
    val heartScale = animateFloatAsState(
        targetValue = if (product.favourites) 1.2f else 1f,
        animationSpec = androidx.compose.animation.core.spring(dampingRatio = 0.6f, stiffness = 200f)
    ).value

    Box(
        modifier = Modifier
            .size(160.dp, 182.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(8.dp)
    ) {
        val heartImage = if (product.favourites) R.drawable.heart_red else R.drawable.heart
        Image(
            painter = painterResource(id = heartImage),
            contentDescription = null,
            modifier = Modifier
                .size(28.dp)
                .align(Alignment.TopStart)
                .padding(4.dp)
                .clickable {
                    onProductClick(product.copy(favourites = !product.favourites))
                }
                .scale(heartScale)
                .background(Red, shape = RoundedCornerShape(50))
        )

        Image(
            painter = painterResource(id = product.image),
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .size(142.dp, 70.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 8.dp, bottom = 8.dp)
        ) {
            Text(text = product.bestSeller, fontSize = 16.sp, color = Accent)

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = product.name, fontSize = 16.sp, color = Hint)

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "₽${product.price}", fontSize = 14.sp, color = com.example.profissionals_matule.ui.theme.Text)
        }

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.add_product),
            contentDescription = null,
            modifier = Modifier
                .size(34.dp)
                .align(Alignment.BottomEnd)
                .padding(0.dp)
                .offset(y = 10.dp, x = 10.dp)
        )
    }
}

@Preview
@Composable
fun ShowProduct() {
    val product = Product(
        id = 1,
        image = R.drawable.image_2,
        bestSeller = "BEST SELLER",
        name = "Nike Air MAX",
        price = 752.00F,
        favourites = true
    )

    ProductCard(product)
}
