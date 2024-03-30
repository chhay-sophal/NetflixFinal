package com.example.netflix_final.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Brush
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
import com.example.netflix_final.models.anime
import com.example.netflix_final.models.continueWatching
import com.example.netflix_final.models.featureMovies
import com.example.netflix_final.models.ifYouLikeMarvel
import com.example.netflix_final.models.likeDune
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 0f,
                        endY = 300f,
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 0.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Resume the Way", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                LazyRow {
                    items(continueWatching.size) {
                        MovieBox(navController = navController, movie = continueWatching[it])
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 0.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Stranger Things Alike", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                LazyRow {
                    items(likeDune.size) {
                        likeDune[it]?.let { it1 -> MovieBox(navController = navController, movie = it1) }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 0.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "K-Drama", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                LazyRow {
                    items(likeDune.size) {
                        ifYouLikeMarvel[it]?.let { it1 -> MovieBox(navController = navController, movie = it1) }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 0.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Anime", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                LazyRow {
                    items(likeDune.size) {
                        likeDune[it]?.let { it1 -> MovieBox(navController = navController, movie = it1) }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 0.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "C-Drama", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                LazyRow {
                    items(anime.size) {
                        anime[it]?.let { it1 -> MovieBox(navController = navController, movie = it1) }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 0.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Just Released", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                LazyRow {
                    items(featureMovies.size) {
                        featureMovies[it]?.let { it1 -> MovieBox(navController = navController, movie = it1) }
                    }
                }
            }
        }
    }
}

