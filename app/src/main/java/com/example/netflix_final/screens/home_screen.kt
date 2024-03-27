package com.example.netflix_final.screens

import android.content.ClipData.Item
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.netflix_final.models.MovieModel
import com.example.netflix_final.models.continueWatching
import com.example.netflix_final.models.formatDuration
import com.example.netflix_final.models.loggedInUser
import com.example.netflix_final.models.movieList
import java.time.Duration
import java.time.Year

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black,
        contentColor = Color.White
    ) {
        Box() {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)) {

                ComposeSuggestFilms()

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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
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
                        .fillMaxWidth(),
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

                Spacer(modifier = Modifier.height(450.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(horizontal = 0.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Continue watching", fontSize = 17.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(bottom = 5.dp, start = 10.dp))
                    LazyRow {
//                        Place columns here
                        items(continueWatching.size) {
                            MovieBox(movie = continueWatching[it])
                        }
                    }
                }
                
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class) @Composable
fun ComposeSuggestFilms() {
    val pagerState = rememberPagerState( pageCount = { movieList.size } )
    HorizontalPager(state = pagerState) {
        MovieCard(movie = movieList[it])
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieCard(movie: MovieModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 470.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val context = LocalContext.current

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
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(Icons.Rounded.Add, contentDescription = "Back")
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

@Composable
fun MovieBox(movie: MovieModel) {
    Box(modifier = Modifier
        .width(110.dp)
        .height(160.dp)
        .padding(start = 10.dp)
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