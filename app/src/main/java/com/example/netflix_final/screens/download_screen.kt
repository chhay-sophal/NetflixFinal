package com.example.netflix_final.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun DownloadScreen(navController: NavController) {
    val verticalScrollState = rememberScrollState()

    val titleText by remember {
        derivedStateOf {
            if (verticalScrollState.value > 100) {
                "Downloads"
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
            DownloadScreenContent(navController = navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewDownloadScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "download") {
        composable("download") {
            DownloadScreen(navController = navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DownloadScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Text(text = "Downloads", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.LightGray, modifier = Modifier.padding(bottom = 10.dp, start = 15.dp))

        for (i in 0 until download.size step 2) {
            Row(modifier = Modifier
                .height(150.dp)
                .padding(10.dp)) {
                // Display the first movie in the row
                Surface(
                    modifier = Modifier
                        .width(170.dp)
                        .padding(horizontal = 3.dp),
                    color = Color.Transparent,
                    contentColor = Color.White,
                    onClick = {
                        navController.navigate("movie-details/${download[i]?.title}")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), shape = RoundedCornerShape(10.dp), color = Color.Gray) {
                            AsyncImage(
                                model = download[i]?.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        download[i]?.title?.let {
                            Text(
                                text = it,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                }

                if (i + 1 < download.size) {
                    Surface(
                        modifier = Modifier
                            .width(170.dp)
                            .padding(horizontal = 3.dp),
                        color = Color.Transparent,
                        contentColor = Color.White,
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            navController.navigate("movie-details/${download[i + 1]?.title}")
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Surface(modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp), shape = RoundedCornerShape(10.dp), color = Color.Gray) {
                                AsyncImage(
                                    model = download[i + 1]?.image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            download[i + 1]?.let {
                                Text(
                                    text = it.title,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
