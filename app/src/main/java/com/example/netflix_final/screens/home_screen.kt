package com.example.netflix_final.screens

import android.content.ClipData.Item
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.R
import com.example.netflix_final.components.ComposableBottomAppBar
import com.example.netflix_final.models.MovieModel
import com.example.netflix_final.models.continueWatching
import com.example.netflix_final.models.featureFilms
import com.example.netflix_final.models.formatDuration
import com.example.netflix_final.models.likeDune
import com.example.netflix_final.models.loggedInUser
import com.example.netflix_final.models.movieList
import com.example.netflix_final.models.myList
import java.time.Duration
import java.time.Year

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController, pagerState: PagerState, scrollState: ScrollState) {
    Scaffold(
            bottomBar = { ComposableBottomAppBar(navController) }
            ){ paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            HomeScreenContent(navController, pagerState, scrollState)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreenContent(navController: NavController, pagerState: PagerState, scrollState: ScrollState) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black,
        contentColor = Color.White
    ) {
        Box() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(scrollState)
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp)) {

                    ComposeSuggestFilms(navController = navController, pagerState = pagerState)

                    Box(modifier = Modifier
                        .fillMaxSize()
                        .height(650.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color.Black, Color.Transparent),
                                startY = 0f,
                                endY = 200f,
                            )
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(20.dp, 20.dp)
                        .background(Color.Transparent),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(model = R.drawable.n_logo, contentDescription = "N Logo")
                    Spacer(modifier = Modifier.weight(1f))
                    AsyncImage(model = loggedInUser.profile, contentDescription = "User Profile", modifier = Modifier.clip(shape = RoundedCornerShape(3.dp)))
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    val context = LocalContext.current

                    Button(
                        onClick = {
                            Toast.makeText( context,
                                "TV Shows",
                                Toast.LENGTH_SHORT ).show()
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Text(text = "TV Shows")
                    }
                    Button(
                        onClick = {
                            Toast.makeText( context,
                                "Movies",
                                Toast.LENGTH_SHORT ).show()
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Text(text = "Movies")
                    }
                    Button(
                        onClick = {
                            Toast.makeText( context,
                                "Categories",
                                Toast.LENGTH_SHORT ).show()
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Text(text = "Categories")
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 600.dp)
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
                        Text(text = "Continue watching", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
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
                        Text(text = "More like Dune", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                        LazyRow {
                            items(likeDune.size) {
                                MovieBox(navController = navController, movie = likeDune[it])
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
                        Text(text = "More like Dune", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                        LazyRow {
                            items(likeDune.size) {
                                MovieBox(navController = navController, movie = likeDune[it])
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
                        Text(text = "More like Dune", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                        LazyRow {
                            items(likeDune.size) {
                                MovieBox(navController = navController, movie = likeDune[it])
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    val pagerState = rememberPagerState(pageCount = { featureFilms.size })
    val scrollState = rememberScrollState()
    HomeScreen(navController, pagerState, scrollState)
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class) @Composable
fun ComposeSuggestFilms(navController: NavController, pagerState: PagerState) {
    HorizontalPager(state = pagerState) {
        MovieCard(navController = navController, movie = featureFilms[it])
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieCard(navController: NavController, movie: MovieModel) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.Black,
        contentColor = Color.White,
        onClick = {
            navController.navigate("movie-details/${movie.title}")
        }
//        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(590.dp)
            ,
        ) {
            AsyncImage(
                model = movie.image,
                contentDescription = movie.title,
                modifier = Modifier.fillMaxWidth()
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black, Color.Transparent),
                        startY = 1600f,
                        endY = 1200f,
                    )
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 470.dp),
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    movie.genre?.let {
                        items(it.size) {
                            Text(text = movie.genre[it].name, modifier = Modifier.padding(horizontal = 5.dp))
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    val context = LocalContext.current

                    Button(
                        onClick = {
                            if (myList.contains(movie)) {
                                myList.removeAll { it == movie } // Safely remove movie from myList
                                Toast.makeText(
                                    context,
                                    "${movie.title} removed from My List",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                myList.add(movie) // Safely add movie to myList
                                Toast.makeText(
                                    context,
                                    "${movie.title} added to My List",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(0.dp),
                        modifier = Modifier.padding(end = 10.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
//                            Icon(Icons.Rounded.Add, contentDescription = "Back")
//                            Text(text = "My List")
                            if (myList.contains(movie)) {
                                Icon(imageVector = Icons.Rounded.Delete, contentDescription = null)
                            } else {
                                Icon(imageVector = Icons.Rounded.AddCircle, contentDescription = null)
                            }
                            Text(text = "My List")
                        }
                    }
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Categories",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(0.dp),
                        modifier = Modifier.padding(horizontal = 10.dp)
                    ) {
                        Icon(Icons.Rounded.PlayArrow, contentDescription = "Play", tint = Color.Black)
                        Text(text = "Play", color = Color.Black)
                    }
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Movies",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(0.dp),
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(Icons.Rounded.Info, contentDescription = "Info")
                            Text(text = "Info")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MovieBox(navController: NavController, movie: MovieModel) {
    Surface(
        modifier = Modifier
            .width(110.dp)
            .height(160.dp)
            .padding(start = 10.dp),
        color = Color.Transparent,
        onClick = {
            navController.navigate("movie-details/${movie.title}")
        }
    ) {
        AsyncImage(model = movie.image, contentDescription = movie.description, modifier = Modifier.fillMaxSize())
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier
                    .size(50.dp)
                    .border(1.dp, Color.White, CircleShape)
                    .background(Color.Gray.copy(alpha = 0.5f), CircleShape),
                color = Color.Transparent
            ) {
                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null)
            }
        }
    }
}