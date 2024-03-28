package com.example.netflix_final.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.models.CastModel
import com.example.netflix_final.models.MovieModel
import com.example.netflix_final.models.featureFilms
import com.example.netflix_final.models.formatDuration

@Composable()
fun MovieDetailsScreen(navController: NavController, movie: MovieModel) {
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black,
        contentColor = Color.White
    ) {
        Poster(movie = movie, navController = navController)

        Content(verticalScrollState = verticalScrollState, horizontalScrollState = horizontalScrollState, movie = movie)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable()
fun PreviewMovieDetailsScreen() {
    MovieDetailsScreen(navController = rememberNavController(), movie = featureFilms[0])
}

@Composable
fun Poster(movie: MovieModel, navController: NavController) {
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(590.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray))

            AsyncImage(model = movie.image, contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth())

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
                Spacer(modifier = Modifier.weight(1.5f))
            }
        }
    }
}

@Composable
fun Content(verticalScrollState: ScrollState, horizontalScrollState: ScrollState, movie: MovieModel) {
    Box(
        modifier = Modifier
            .verticalScroll(verticalScrollState)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = 1500f,
                    endY = 1700f,
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 600.dp)
                .padding(horizontal = 10.dp)
        ) {
            TitleAndInfo(movie = movie)

            PlayAndDownloadButtons(movie = movie)

            DescriptionsSection(movie = movie)

            TrailerSection(movie = movie)

            BonusContentSection(movie = movie, horizontalScrollState = horizontalScrollState)

            if (movie.cast?.isNotEmpty() == true) {
                CastSection(cast = movie.cast)
            }
        }
    }
}

// Title and Info section
@Composable()
fun TitleAndInfo(movie: MovieModel) {
    //                Title
    Box() {
        Text(text = movie.title, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }

//                Info
    Column() {
        Text(text = "Year: " + movie.year.toString(), fontWeight = FontWeight.Normal)
        Text(text = "Duration: " + formatDuration(movie.duration), fontWeight = FontWeight.Normal)
        Row {
            Text(text = "Genre:", fontWeight = FontWeight.Normal)
            LazyRow {
                items(movie.genre.size) {
                    Text(text = movie.genre[it].name, fontWeight = FontWeight.Normal, modifier = Modifier.padding(horizontal = 5.dp))
                }
            }
        }
    }
}

// Play and Download button
@Composable()
fun PlayAndDownloadButtons(movie: MovieModel) {
    //                Play Button
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

//                Download Button
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

// Descriptions
@Composable()
fun DescriptionsSection(movie: MovieModel) {
    Box(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        Text(text = movie.description, style = TextStyle(lineHeight = 23.sp))
    }
}
// Trailer
@Composable()
fun TrailerSection(movie: MovieModel) {
    Column {
        Text(text = "Trailer", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Surface(
            modifier = Modifier
                .height(120.dp)
                .width(180.dp)
                .padding(vertical = 10.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            AsyncImage(model = movie.image, contentDescription = null, contentScale = ContentScale.Crop)
            Button(
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(100.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.fillMaxSize())
            }
        }
        Text(text = movie.title + " Trailer")
    }
}

// Bonus Content
@Composable()
fun BonusContentSection(movie: MovieModel, horizontalScrollState: ScrollState) {
    Column(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        Text(text = "Bonus Content", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Box(
            modifier = Modifier
                .horizontalScroll(horizontalScrollState)
        ) {
            Row {
                Column(modifier = Modifier.padding(end = 20.dp)) {
                    Surface(
                        modifier = Modifier
                            .height(120.dp)
                            .width(180.dp)
                            .padding(vertical = 10.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        AsyncImage(model = movie.image, contentDescription = null, contentScale = ContentScale.Crop)
                        Button(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .size(100.dp),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.fillMaxSize())
                        }
                    }
                    Text(text = "The making of " + movie.title)
                }

                Column(modifier = Modifier.padding(end = 20.dp)) {
                    Surface(
                        modifier = Modifier
                            .height(120.dp)
                            .width(180.dp)
                            .padding(vertical = 10.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        AsyncImage(model = movie.image, contentDescription = null, contentScale = ContentScale.Crop)
                        Button(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .size(100.dp),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.fillMaxSize())
                        }
                    }
                    Text(text = "First Look")
                }

                Column(modifier = Modifier.padding(end = 20.dp)) {
                    Surface(
                        modifier = Modifier
                            .height(120.dp)
                            .width(180.dp)
                            .padding(vertical = 10.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        AsyncImage(model = movie.image, contentDescription = null, contentScale = ContentScale.Crop)
                        Button(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .size(100.dp),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.fillMaxSize())
                        }
                    }
                    Text(text = "Behind the Scence")
                }
            }
        }
    }
}

// Cast Content
@Composable()
fun CastSection(cast: List<CastModel>) {
    Column(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        Text(text = "Cast", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Box(modifier = Modifier.padding(top = 10.dp)) {
            LazyRow {
                items(cast.size) {
                    Column(
                        modifier = Modifier.padding(end = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp),
                            shape = CircleShape
                        ) {
                            AsyncImage(model = cast[it].imageUrl, contentDescription = null, contentScale = ContentScale.Crop)
                        }
                        Text(text = cast[it].actorName, modifier = Modifier.padding(top = 5.dp))
                    }
                }
            }
        }
    }
}
