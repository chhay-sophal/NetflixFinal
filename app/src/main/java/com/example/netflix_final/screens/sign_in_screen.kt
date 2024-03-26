package com.example.netflix_final.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.R
import kotlin.math.round

@OptIn(ExperimentalFoundationApi::class)
@Composable()
fun SignInScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.DarkGray
    ) {
        Box(modifier = Modifier.height(50.dp)) {
            ComposeTopBar(navController)
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(300.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(5.dp))
                        .padding(10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = "Email or phone number", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Normal)
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(5.dp))
                        .padding(10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = "Password", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Normal)
                    Text(text = "SHOW", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Normal, modifier = Modifier.align(Alignment.CenterEnd))
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(Color.Red, shape = RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = "Sign In", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Normal, modifier = Modifier.align(Alignment.Center))
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(text = "Recover Password", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Normal, modifier = Modifier.align(Alignment.Center))
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sign in is protected by Google reCAPTCHA to ensure you're not a bot. Learn more.",
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(navController = rememberNavController());
}

@OptIn(ExperimentalMaterial3Api::class) @Composable
fun ComposeTopBar(navController: NavController) {
    TopAppBar( navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Rounded.ArrowBack, contentDescription = "Back") }
    },
        title = {},
        colors = topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
        actions = {
            Spacer(Modifier.weight(2.5f))
            Box(
                modifier = Modifier
                    .weight(6f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = R.drawable.netflix_logo,
                    contentDescription = "Netflix Logo",
                    modifier = Modifier.height(50.dp)
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Share")
            }
        }
    )
}