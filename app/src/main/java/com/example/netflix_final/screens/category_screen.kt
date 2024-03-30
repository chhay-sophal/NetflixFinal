package com.example.netflix_final.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
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
import com.example.netflix_final.models.movieList

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CategoryScreen(navController: NavController, selection: String?) {
    val verticalScrollState = rememberScrollState()

    val titleText by remember {
        derivedStateOf {
            if (verticalScrollState.value > 100) {
                when (selection) {
                    "Horror" -> "Horror"
                    "Action" -> "Action"
                    "Comedy" -> "Comedy"
                    "Drama" -> "Drama"
                    "Science Fiction" -> "Science Fiction"
                    "Thriller" -> "Thriller"
                    "Adventure" -> "Adventure"
                    "Romance" -> "Romance"
                    "Anime" -> "Anime"
                    else -> "Cartoon"
                }
            } else {
                ""
            }
        }
    }

    Scaffold(
        bottomBar = { ComposableBottomAppBar(navController) },
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Rounded.KeyboardArrowLeft, contentDescription = "Back", modifier = Modifier.size(40.dp))
                    }
                },
                title = { Text(text = titleText ) },
                colors = topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                ),
                actions = { },
            )
        },
    ){ paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black),
            color = Color.Black,
            contentColor = Color.White,
        ){
            if (selection != null) {
                CategoryScreenContent(navController = navController, verticalScrollState, selection)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewCategoryScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "tv-show") {
        composable("tv-show") {
            CategoryScreen(navController = navController, "TV Shows")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CategoryScreenContent(navController: NavController, verticalScrollState: ScrollState, titleText: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .verticalScroll(verticalScrollState)
            .fillMaxSize()
    ) {
        Text(text = titleText, fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.LightGray, modifier = Modifier.padding(bottom = 10.dp, start = 15.dp))

        for (i in 0 until movieList.size step 2) {
            Row(
                modifier = Modifier
                    .height(150.dp)
                    .padding(10.dp)
            ) {
                // Display the first movie in the row
                Surface(
                    modifier = Modifier
                        .width(170.dp)
                        .padding(horizontal = 3.dp),
                    color = Color.Transparent,
                    contentColor = Color.White,
                    onClick = {
                        navController.navigate("movie-details/${movieList[i].title}")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            shape = RoundedCornerShape(10.dp),
                            color = Color.Gray
                        ) {
                            AsyncImage(
                                model = movieList[i].image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        movieList[i].title.let {
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

                if (i + 1 < movieList.size) {
                    Surface(
                        modifier = Modifier
                            .width(170.dp)
                            .padding(horizontal = 3.dp),
                        color = Color.Transparent,
                        contentColor = Color.White,
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            navController.navigate("movie-details/${movieList[i + 1].title}")
                        }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp),
                                shape = RoundedCornerShape(10.dp),
                                color = Color.Gray
                            ) {
                                AsyncImage(
                                    model = movieList[i + 1].image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(
                                text = movieList[i + 1].title,
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

