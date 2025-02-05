package com.example.profissionals_matule.presentation.on_boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissionals_matule.ui.theme.Accent

@Composable
fun OnBoardingOnePage(onBoardingModel: OnBoardingModel){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Spacer(
            modifier = Modifier
                .size(70.dp)
        )
        Text(
            text = onBoardingModel.title_first,
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Spacer(
            modifier = Modifier
                .size(100.dp)
        )
        Image(
            painter = painterResource(id = onBoardingModel.image_bottom),
            contentDescription = null,
            modifier = Modifier
                .size(375.dp, 302.dp),
            alignment = Alignment.CenterEnd
        )
    }
}
@Composable
fun OnBoardingTwoAndThreePage(onBoardingModel: OnBoardingModel){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Spacer(
            modifier = Modifier
                .size(70.dp)
        )
        Image(
            painter = painterResource(id = onBoardingModel.image_top),
            contentDescription = null,
            modifier = Modifier
                .size(375.dp, 302.dp),
            alignment = Alignment.Center
        )
        Spacer(
            modifier = Modifier
                .size(60.dp)
        )
        Text(
            text = onBoardingModel.title_second,
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
        Text(
            text = onBoardingModel.description,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp
        )
    }
}

@Preview
@Composable
fun OnBoardingPrewiew1(){
    OnBoardingOnePage(OnBoardingModel.FirstPage)
}
@Preview
@Composable
fun OnBoardingPrewiew2(){
    OnBoardingTwoAndThreePage(OnBoardingModel.SecondPage)
}
@Preview
@Composable
fun OnBoardingPrewiew3(){
    OnBoardingTwoAndThreePage(OnBoardingModel.ThirdPage)
}