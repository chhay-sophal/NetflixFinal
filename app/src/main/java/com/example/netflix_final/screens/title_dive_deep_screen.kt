package com.example.netflix_final.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.models.MovieModel
import com.example.netflix_final.models.featureFilms

@Composable()
fun TitleDiveDeepScreen(navController: NavController, movie: MovieModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black,
        contentColor = Color.White
    ) {
        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray))

                AsyncImage(model = movie.image, contentDescription = null, modifier = Modifier.fillMaxWidth())

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Surface(
                            color = Color.Transparent,
                            onClick = {
                                navController.navigate("home")
                            }
                        ) {
                            Icon(imageVector = Icons.Rounded.Close, contentDescription = null, tint = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Surface(
                            modifier = Modifier
                                .size(50.dp)
                                .border(1.dp, Color.White, CircleShape)
                                .background(Color.Gray.copy(alpha = 0.5f), CircleShape),
                            color = Color.Transparent
                        ) {
                            Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null, tint = Color.White)
                        }
                    }
                    Spacer(modifier = Modifier.weight(2f))
                }
            }

            Box(
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = movie.title, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }

            Row(
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Text(text = movie.year.toString(), fontSize = 11.sp, fontWeight = FontWeight.Normal)
                Text(text = "Genre:", fontSize = 11.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(start = 10.dp, end = 5.dp))
                LazyRow {
                    items(movie.genre.size) {
                        Text(text = movie.genre[it].name, fontSize = 11.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(horizontal = 5.dp))
                    }
                }
            }

            val context = LocalContext.current
            Surface(
                modifier = Modifier
                    .height(45.dp)
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                color = Color.White,
                contentColor = Color.Black,
                onClick = {
                    Toast.makeText( context,
                        "This is a toast message",
                        Toast.LENGTH_SHORT ).show()
                }
            ){
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null, tint = Color.Black)
                    Text(text = "Play", fontWeight = FontWeight.Medium, modifier = Modifier.padding(start = 5.dp))
                }
            }
            Surface(
                modifier = Modifier
                    .height(45.dp)
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                color = Color.DarkGray,
                contentColor = Color.Gray,
                onClick = {
                    Toast.makeText( context,
                        "This is a toast message",
                        Toast.LENGTH_SHORT ).show()
                }
            ){
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(imageVector = Icons.Rounded.AddCircle, contentDescription = null, tint = Color.Gray)
                    Text(text = "Download", fontWeight = FontWeight.Medium, modifier = Modifier.padding(start = 5.dp))
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable()
fun PreviewTitleDiveDeepScreen() {
    TitleDiveDeepScreen(navController = rememberNavController(), movie = featureFilms[1])
}