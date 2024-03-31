package com.example.netflix_final.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.components.ComposableBottomAppBar
import com.example.netflix_final.components.ComposableTopAppBar
import com.example.netflix_final.models.download

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotificationsScreen(navController: NavController) {
    val verticalScrollState = rememberScrollState()

    val titleText by remember {
        derivedStateOf {
            if (verticalScrollState.value > 100) {
                "Notifications"
            } else {
                ""
            }
        }
    }

    Scaffold(
        topBar = { ComposableTopAppBar(navController = navController, titleText = titleText)},
        bottomBar = { ComposableBottomAppBar(navController) }
    ){ paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black),
            color = Color.Black,
            contentColor = Color.White,
        ){
            NotificationsScreenContent(navController = navController, verticalScrollState)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewNotificationsScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "download") {
        composable("download") {
            NotificationsScreen(navController = navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotificationsScreenContent(navController: NavController, verticalScrollState: ScrollState) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp)
            .verticalScroll(verticalScrollState)
            .fillMaxSize()
    ) {
        Text(text = "Notifications", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.LightGray, modifier = Modifier.padding(bottom = 10.dp, start = 15.dp))

        Column(modifier = Modifier.padding(top = 10.dp)) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://image.tmdb.org/t/p/original/rqeGrcvTK1BRqjEN0gScsYegA4c.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 30th", fontWeight = FontWeight.Bold)
                        Text(text = "Get a first look today.", fontSize = 13.sp)
                        Text(text = "Today", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://www.joblo.com/wp-content/uploads/2024/01/godzilla-x-kong-arm-1280x720.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 29th", fontWeight = FontWeight.Bold)
                        Text(text = "Play the trailer", fontSize = 13.sp)
                        Text(text = "Yesterday", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://image.tmdb.org/t/p/original/rqeGrcvTK1BRqjEN0gScsYegA4c.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 30th", fontWeight = FontWeight.Bold)
                        Text(text = "Get a first look today.", fontSize = 13.sp)
                        Text(text = "Today", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://www.joblo.com/wp-content/uploads/2024/01/godzilla-x-kong-arm-1280x720.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 29th", fontWeight = FontWeight.Bold)
                        Text(text = "Play the trailer", fontSize = 13.sp)
                        Text(text = "Yesterday", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://image.tmdb.org/t/p/original/rqeGrcvTK1BRqjEN0gScsYegA4c.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 30th", fontWeight = FontWeight.Bold)
                        Text(text = "Get a first look today.", fontSize = 13.sp)
                        Text(text = "Today", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://www.joblo.com/wp-content/uploads/2024/01/godzilla-x-kong-arm-1280x720.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 29th", fontWeight = FontWeight.Bold)
                        Text(text = "Play the trailer", fontSize = 13.sp)
                        Text(text = "Yesterday", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://image.tmdb.org/t/p/original/rqeGrcvTK1BRqjEN0gScsYegA4c.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 30th", fontWeight = FontWeight.Bold)
                        Text(text = "Get a first look today.", fontSize = 13.sp)
                        Text(text = "Today", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(85.dp),
                color = Color.Transparent,
                onClick = {}
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(140.dp)
                            .padding(horizontal = 10.dp),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        AsyncImage(model = "https://www.joblo.com/wp-content/uploads/2024/01/godzilla-x-kong-arm-1280x720.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                    }
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                        Text(text = "Coming March 29th", fontWeight = FontWeight.Bold)
                        Text(text = "Play the trailer", fontSize = 13.sp)
                        Text(text = "Yesterday", fontSize = 10.sp, color = Color.LightGray)
                    }
                }
            }
        }
    }
}
