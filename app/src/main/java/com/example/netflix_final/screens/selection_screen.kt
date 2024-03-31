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
import com.example.netflix_final.components.ComposableTopAppBar
import com.example.netflix_final.models.anime
import com.example.netflix_final.models.continueWatching
import com.example.netflix_final.models.featureMovies
import com.example.netflix_final.models.ifYouLikeMarvel
import com.example.netflix_final.models.likeDune
import com.example.netflix_final.models.moreLikeThis
import com.example.netflix_final.models.movieList

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SelectionScreen(navController: NavController, selection: String) {
    val verticalScrollState = rememberScrollState()

    val titleText by remember {
        derivedStateOf {
            if (verticalScrollState.value > 100) {
                if (selection == "TV Shows") "TV Shows" else if (selection == "Movies") "Movies" else "Categories"
            } else {
                ""
            }
        }
    }

    Scaffold(
        bottomBar = { ComposableBottomAppBar(navController) },
        topBar = { ComposableTopAppBar(navController = navController, titleText = titleText) },
    ){ paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black),
            color = Color.Black,
            contentColor = Color.White,
        ){
            SelectionScreenContent(navController = navController, verticalScrollState, selection)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewSelectionScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "tv-show") {
        composable("tv-show") {
            SelectionScreen(navController = navController, "TV Shows")
        }
    }
}

data class Category(val name: String, val image: String)

val categoryList: MutableList<Category> = mutableListOf(
    Category("Horror", "https://media.cnn.com/api/v1/images/stellar/prod/190828152641-us-movie-still.jpg?q=x_2,y_66,h_898,w_1596,c_crop/h_833,w_1480"),
    Category("Action", "https://www.rollingstone.com/wp-content/uploads/2021/06/ACTION-FMOIVES_WEB-1.jpg?w=1600&h=900&crop=1"),
    Category("Comedy", "https://img.freepik.com/free-vector/floating-laughing-emoji-characters_52683-27761.jpg"),
    Category("Drama", "https://theorientaldialogue.com/wp-content/uploads/2023/09/WhatsApp-Image-2023-09-27-at-11.59.27.jpeg"),
    Category("Science Fiction", "https://cdn.britannica.com/09/92009-050-122EC720/Enterprise-from-Star-Trek-III-The-Search.jpg"),
    Category("Thriller", "https://www.rollingstone.com/wp-content/uploads/2018/06/rs-13177-thriller-624-1382985460.jpg"),
    Category("Adventure", "https://greggvanourek.com/wp-content/uploads/2022/04/Adventure-hiking-among-clouds.jpg"),
    Category("Romance", "https://burst.shopifycdn.com/photos/love-and-romance-on-fur.jpg?width=1000&format=pjpg&exif=0&iptc=0"),
    Category("Anime", "https://t4.ftcdn.net/jpg/05/62/02/41/360_F_562024161_tGM4lFlnO0OczLYHFFuNNdMUTG9ekHxb.jpg"),
    Category("Cartoon", "https://wallpapers.com/images/featured/cartoon-pictures-q3hxkk0gmw6vnivj.jpg"),
)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SelectionScreenContent(navController: NavController, verticalScrollState: ScrollState, titleText: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .verticalScroll(verticalScrollState)
            .fillMaxSize()
    ) {
        Text(text = titleText, fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.LightGray, modifier = Modifier.padding(bottom = 10.dp, start = 15.dp))

        if (titleText == "Categories") {
            for (i in 0 until categoryList.size step 2) {
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
                            navController.navigate("home/categories/${categoryList[i].name}")
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
                                    model = categoryList[i].image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(
                                text = categoryList[i].name,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
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
                                navController.navigate("home/categories/${categoryList[i + 1].name}")
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
                                        model = categoryList[i + 1].image,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.Crop
                                    )
                                }

                                Text(
                                    text = categoryList[i + 1].name,
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
        } else {
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
}

