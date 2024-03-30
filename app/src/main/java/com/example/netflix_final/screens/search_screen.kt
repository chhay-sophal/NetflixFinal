package com.example.netflix_final.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.components.ComposableBottomAppBar
import com.example.netflix_final.models.Anime
import com.example.netflix_final.models.MovieModel
import com.example.netflix_final.models.SearchMovieModel
import com.example.netflix_final.models.continueWatching
import com.example.netflix_final.models.likeDune
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewSearchScreen() {
    SearchScreen( navController = rememberNavController())
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieContent(navController: NavController) {
    Surface(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(20.dp),
        color = Color.Black
    ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(horizontal = 0.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Movies & Tv", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Color.White, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                    LazyRow {
                        items(continueWatching.size) {
                            MovieCardImage(movie = continueWatching[it], navController = navController)
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
                    Text(text = "Romantic TV Shows", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Color.White, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                    LazyRow {
                        items(likeDune.size) {
                            MovieCardImage(movie = likeDune[it], navController = navController)
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
                    Text(text = "New on NetFlix", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Color.White, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                    LazyRow {
                        items(likeDune.size) {
                            MovieCardImage(movie = likeDune[it], navController = navController)
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
                    Text(text = "Anime", fontSize = 17.sp, fontWeight = FontWeight.Medium, color = Color.White, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                    LazyRow {
                        items(Anime.size) {
                            MovieCardImage(searchMovieModel = Anime[it], navController = navController)
                        }
                    }
                }
            }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchScreen(navController : NavController){
    val currentSearchText = remember { mutableStateOf("") }
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            SearchTopBar(
                searchText = currentSearchText.value,
                onTextChange = { currentSearchText.value = it },
            )
        },
        bottomBar = {
            ComposableBottomAppBar(navController = navController )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                MovieContent(navController)
            }
        }
    )
}

@Composable
fun MovieCardImage(movie: MovieModel? = null, searchMovieModel: SearchMovieModel? = null, navController: NavController) {
    Surface(modifier = Modifier
        .width(110.dp)
        .height(160.dp)
        .padding(start = 10.dp),
        onClick = {
            navController.navigate("movie-details/${movie?.title}")
        }
    ) {
        movie?.let {
            AsyncImage(model = it.image, contentDescription = it.description, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        }
    }
}


@Composable
fun SearchTopBar(
    searchText: String,
    onTextChange: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(vertical = 12.dp),
        color = Color.Black
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchText,
                onValueChange = onTextChange,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .heightIn(40.dp)
                    .background(Color.Transparent)
                    .clip(shape = RoundedCornerShape(10.dp)),
                placeholder = {
                    Text(text = "Search...", textAlign = TextAlign.Center)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search Icon",
                        modifier = Modifier.size(20.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = "Clear Input Icon",
                        modifier = Modifier
                            .clickable { searchText.replace(searchText, "") }
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(color = Color.Gray)
                    )
                }
            )

            val coroutineScope = rememberCoroutineScope()
            val keyboardController = LocalSoftwareKeyboardController.current
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                color = Color.Black,
                contentColor = Color.White,
                onClick = {
                    coroutineScope.launch {
                        keyboardController?.hide()
                    }
                },
                shape = RoundedCornerShape(30.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Cancel",
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}