package com.example.netflix_final.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.components.ComposableBottomAppBar
import com.example.netflix_final.models.myList

@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        bottomBar = { ComposableBottomAppBar(navController) }
    ){ paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.DarkGray),
            color = Color.Black,
            contentColor = Color.White,
        ){
            SettingsContent(navController = navController)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen(navController = rememberNavController())
}

@Composable
fun SettingsContent(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Text(text = "Settings", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.LightGray, modifier = Modifier.padding(bottom = 10.dp, start = 15.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 3.dp),
            color = Color.DarkGray,
            contentColor = Color.White,
            shape = RoundedCornerShape(15),
        ) {
            Column {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    onClick = {
                    }
                ) {
                    Text(
                        text = "Manage Subscriptions",
                        color = Color(135,193,255),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 15.dp)
                    )
                }

                Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp))

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    onClick = {
                    }
                ) {
                    Text(
                        text = "Redeem Gift Card or Code",
                        color = Color(135,193,255),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 15.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 3.dp),
            color = Color.DarkGray,
            contentColor = Color.White,
            shape = RoundedCornerShape(15),
        ) {
            Column {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    onClick = {
                    }
                ) {
                    Text(
                        text = "Clear Play History",
                        textAlign = TextAlign.Center,
                        color = Color.Red,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 15.dp)
                    )
                }
            }
        }
        Text(
            text = "Clear what you've watched from your device.",
            textAlign = TextAlign.Start,
            fontSize = 11.sp,
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 3.dp),
            color = Color.DarkGray,
            contentColor = Color.White,
            shape = RoundedCornerShape(15),
        ) {
            Column {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    onClick = {
                    }
                ) {
                    Text(
                        text = "Allow Notifications on This Phone",
                        color = Color(135,193,255),
                        textAlign = TextAlign.Start,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 15.dp)
                    )
                }
            }
        }
        Text(
            text = "You'll get notifications for similar movies you like, shows you follow, new release, any events, special offers, recommendations, tips and more.",
            textAlign = TextAlign.Start,
            fontSize = 11.sp,
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp),
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sync",
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp)
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 3.dp),
            color = Color.DarkGray,
            contentColor = Color.White,
            shape = RoundedCornerShape(15),
        ) {
            Column {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Sync My Content",
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .padding(vertical = 10.dp, horizontal = 15.dp)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        var isChecked by remember { mutableStateOf(false) }
                        Switch(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                            modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                }
            }
        }
        Text(
            text = "Sync your TV Shows, movies, preference, and more across all of your devices.",
            textAlign = TextAlign.Start,
            fontSize = 11.sp,
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 3.dp),
            color = Color.DarkGray,
            contentColor = Color.White,
            shape = RoundedCornerShape(15),
        ) {
            Column {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.DarkGray,
                    onClick = {
                        navController.navigate("first-screen")
                    }
                ) {
                    Text(
                        text = "Sign Out",
                        textAlign = TextAlign.Start,
                        color = Color(135,193,255),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 15.dp)
                    )
                }
            }
        }
    }
}