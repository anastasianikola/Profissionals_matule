package com.example.profissionals_matule.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profissionals_matule.data.models.CategoryModel

@Composable
fun CategoriesRow(categories: List<CategoryModel>, onCategoryClick: (CategoryModel) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            Button(
                onClick = { onCategoryClick(category) },
                modifier = Modifier.width(108.dp).height(40.dp).padding(4.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = com.example.profissionals_matule.ui.theme.Text
                )
            ) {
                Text(text = category.name)
            }
        }
    }
}

@Preview
@Composable
fun Show() {
    val categories = listOf(
        CategoryModel(1, "Все"),
        CategoryModel(2, "Outdoor"),
        CategoryModel(3, "Tennis"),
        CategoryModel(4, "All Shoes")
    )

    CategoriesRow(categories = categories) { selectedCategory ->
        println("Выбрана категория: ${selectedCategory.name}")
    }
}
