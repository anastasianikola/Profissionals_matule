package com.example.profissionals_matule.presentation.sing_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.profissionals_matule.R
import com.example.profissionals_matule.R.drawable
import com.example.profissionals_matule.ui.theme.Accent
import com.example.profissionals_matule.ui.theme.Block
import com.example.profissionals_matule.ui.theme.Red
import com.example.profissionals_matule.ui.theme.SubTextDark
import com.example.profissionals_matule.ui.theme.SubTextLight


@Composable
fun SignIn(viewModel: SignInViewModel = hiltViewModel(), navController: NavController,){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0))
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 121.dp, start = 20.dp, end = 20.dp)
                .height(416.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(89.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Привет!",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    color = com.example.profissionals_matule.ui.theme.Text
                )
                Text(
                    text = "Заполните Свои данные или\nпродолжите через социальные медиа",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    color = SubTextDark,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(292.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(218.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(186.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "Email"
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it},
                            label = {Text(text = "xyz@gmail.com")},
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Block,
                                unfocusedContainerColor = SubTextLight,
                                focusedBorderColor = Accent,
                                unfocusedBorderColor = SubTextLight,
                                unfocusedTextColor = SubTextDark,
                                focusedTextColor = com.example.profissionals_matule.ui.theme.Text
                            )
                        )
                        Text(
                            text = "Пароль"
                        )
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it},
                            label = {Text(text = "Пароль")},
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Block,
                                unfocusedContainerColor = SubTextLight,
                                focusedBorderColor = Accent,
                                unfocusedBorderColor = SubTextLight,
                                unfocusedTextColor = SubTextDark,
                                focusedTextColor = com.example.profissionals_matule.ui.theme.Text
                            ),
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordVisible = !passwordVisible
                                    }
                                ) {
                                    if (passwordVisible)
                                        Image(
                                            imageVector = ImageVector.vectorResource(R.drawable.eye_open),
                                            contentDescription = ""
                                        )
                                    else
                                        Image(
                                            imageVector = ImageVector.vectorResource(R.drawable.eye_close),
                                            contentDescription = ""
                                        )
                                }
                            }
                        )
                    }
                    Text(
                        text = "Восттановить",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .align(Alignment.End),
                        color = SubTextDark
                    )
                }
                Button(
                    onClick = {
                        if (viewModel.validate(email, password)) {
                            email = ""
                            password = ""
                            error = ""
                            navController.navigate("home")
                        }
                        else if(viewModel.emailError != null){
                            error = viewModel.emailError ?: ""
                        }
                        else if(viewModel.passwordError != null){
                            error = viewModel.passwordError ?: ""
                        }
                        else {
                            error = "Заполните все поля корректно!"
                        }
                    },
                    enabled = email.isNotBlank() && password.isNotBlank(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Accent,
                        contentColor = Block
                    ),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = "Войти"
                    )
                }
                if (error.isNotEmpty()) {
                    Text(
                        text = error,
                        color = Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Absolute.Center
        ){
            Text(
                text = "Вы впервые?",
                color = SubTextDark,
                fontSize = 16.sp
            )
            Text(
                text = "Создать аккаунт",
                color = com.example.profissionals_matule.ui.theme.Text,
                fontSize = 16.sp
            )

        }

    }
}
