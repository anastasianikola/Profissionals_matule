package com.example.profissionals_matule.presentation.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profissionals_matule.ui.theme.Disable

@Composable
fun Indicators(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color.White,
    unselectedColor: Color = Disable
    ){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        repeat(pageSize){
            Spacer(modifier = Modifier.size(3.dp))
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .width(width = if (it == currentPage) 43.dp else 28.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = if(it == currentPage) selectedColor else unselectedColor)
            )
            Spacer(modifier = Modifier.size(3.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorsPriview1(){
    Indicators(pageSize = 3, currentPage = 0)
}
@Preview(showBackground = true)
@Composable
fun IndicatorsPriview2(){
    Indicators(pageSize = 3, currentPage = 1)
}
@Preview(showBackground = true)
@Composable
fun IndicatorsPriview3(){
    Indicators(pageSize = 3, currentPage = 2)
}