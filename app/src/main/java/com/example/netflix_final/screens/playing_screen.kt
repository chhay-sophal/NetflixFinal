package com.example.netflix_final.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.models.MovieModel
import com.example.netflix_final.models.movieList

@Composable
fun PlayingScreen(navController: NavController, movie: MovieModel) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black,
        contentColor = Color.White
    ) {
        Box(modifier = Modifier
            .background(Color.Gray)
            .aspectRatio(16f / 9f)
        ) {
            AsyncImage(model = movie.image, contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        }
        Box(modifier = Modifier.padding(10.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Surface(
                    shape = CircleShape,
                    color = Color.Transparent,
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowLeft, contentDescription = null, modifier = Modifier.size(45.dp))
                }
                Spacer(modifier = Modifier.weight(1f))
                Surface(
                    shape = CircleShape,
                    color = Color.Transparent,
                    onClick = {
                        Toast.makeText(
                            context,
                            "Share button clicked.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Icon(imageVector = Icons.Rounded.Share, contentDescription = null, modifier = Modifier.size(27.dp))
                }
                Surface(
                    shape = CircleShape,
                    color = Color.Transparent,
                    onClick = {
                        Toast.makeText(
                            context,
                            "More button clicked.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = null, modifier = Modifier.size(32.dp))
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Surface(
                shape = CircleShape,
                color = Color.Transparent,
                onClick = {
                    Toast.makeText(
                        context,
                        "Playing the movie...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {
                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(100.dp))
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewPlayingScreen() {
    PlayingScreen(navController = rememberNavController(), movie = movieList[1])
}