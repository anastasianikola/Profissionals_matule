package com.example.profissionals_matule.presentation.on_boarding

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profissionals_matule.ui.theme.Accent

@Composable
fun ButtonUI(
    text: String = "" ,
    backgroundColor: Color = Accent,
    textColor: Color = Color.White,
    fontSize: Int = 14,
    onClick: ()-> Unit
    ){
    Button(
        onClick = onClick,
        colors =  ButtonDefaults.buttonColors(
            contentColor = textColor,
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
        ) {

        Text(
            text = text,
            fontSize = fontSize.sp,
        )
    }
}

@Preview
@Composable
fun StartButtom(){
    ButtonUI(text = "Начать") { }
}

@Preview
@Composable
fun NextButtom(){
    ButtonUI(text = "Далее") { }
}