package com.example.netflix_final.Starter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.netflix_final.R

@Composable
fun Login() {
    FooterFourth()
    HeaderLogin()
    LoginForm()
}

@Composable
fun HeaderLogin(){
    val Bold = FontFamily(Font(R.font.netflixsans_bold))

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.DarkGray
    ){
        Surface (
            modifier = Modifier
                .height(30.dp)
                .padding(0.dp, 0.dp, 0.dp, 750.dp)

            ,
            color = Color.Black

        ){

            Text(text = "Help",
                color = Color.White,
                fontSize = 22.sp,
                modifier = Modifier.padding(start=350.dp, top = 20.dp),
                fontFamily = Bold
            )
            Image(
                modifier = Modifier
                    .padding(0.dp,15.dp,350.dp,20.dp)
                ,
                painter = painterResource(R.drawable.back),
                contentDescription = null,
                )
            Image(
                modifier = Modifier
                    .padding()
                ,
                painter = painterResource(R.drawable.r),
                contentDescription = null,
            )
        }
    }

}
//
//
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(){
    val Regular = FontFamily(Font(R.font.netflixsans_regular))

    val Bold = FontFamily(Font(R.font.netflixsans_bold))
//    val Light = FontFamily(Font(R.font.netflixsans_regular))

        Row(
            modifier = Modifier
                .padding(top = 200.dp)


        ){
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Enter your text", color = Color.White , fontSize = 20.sp, fontFamily = Regular) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = Color.White,
                    disabledTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    disabledBorderColor = Color.White,
                    errorBorderColor = Color.White,
                    errorCursorColor = Color.White,
                    errorLabelColor = Color.White,
                )
            )
        }

}
