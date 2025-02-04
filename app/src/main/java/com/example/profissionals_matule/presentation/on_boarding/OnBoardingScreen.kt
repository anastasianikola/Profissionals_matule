package com.example.profissionals_matule.presentation.on_boarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(onFinished: () -> Unit) {
    val pages = listOf(OnBoardingModel.FirstPage, OnBoardingModel.SecondPage, OnBoardingModel.ThirdPage)
    val pagerState = rememberPagerState(initialPage = 0) { pages.size }
    val coroutineScope = rememberCoroutineScope()
    var buttonText by remember { mutableStateOf("Начать") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E)), // Фон всего экрана
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(state = pagerState) { page ->
                val currentPageData = pages[page]
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    if (page == 0) {
                        OnBoardingOnePage(currentPageData)
                    } else {
                        OnBoardingTwoAndThreePage(currentPageData)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Индикаторы (точки переключения)
            Indicators(pageSize = pages.size, currentPage = pagerState.currentPage)

            Spacer(modifier = Modifier.height(32.dp))

            // Кнопка "Начать" / "Далее"
            ButtonUI(
                text = buttonText,
                onClick = {
                    if (pagerState.currentPage == pages.size - 1) {
                        onFinished()
                    } else {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            buttonText = if (pagerState.currentPage == pages.size - 2) "Завершить" else "Далее"
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnBoarding() {
    OnBoardingScreen { }
}
