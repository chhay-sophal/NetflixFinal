package com.example.netflix_final.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.exoplayer.offline.Download
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.R
import com.example.netflix_final.components.ComposableBottomAppBar
import com.example.netflix_final.models.CastModel
import com.example.netflix_final.models.MovieModel
import com.example.netflix_final.models.featureFilms
import com.example.netflix_final.models.formatDuration
import com.example.netflix_final.models.moreLikeThis
import com.example.netflix_final.models.myList

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(navController: NavController, movie: MovieModel) {
    val verticalScrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()

    val topAppBarContainerColor by remember {
        derivedStateOf {
            if (verticalScrollState.value > 1400) {
                Color.Black
            } else {
                Color.Transparent
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Rounded.KeyboardArrowLeft, contentDescription = "Back", modifier = Modifier.size(40.dp))
                    }
                },
                title = { },
                colors = topAppBarColors(
                    containerColor = topAppBarContainerColor,
                    titleContentColor = Color.Transparent,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                ),
                actions = {
                    IconButton(onClick = {
                        if (myList.contains(movie)) {
                            myList.removeAll { it == movie }
                        } else {
                            myList.add(movie)
                        }
                    }) {
                        if (myList.contains(movie)) {
                            Icon(imageVector = Icons.Rounded.Check, contentDescription = null)
                        } else {
                            Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                        }
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Rounded.Share, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            ComposableBottomAppBar(navController)
        },
        contentColor = Color.White,
        containerColor = Color.Black
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(), contentAlignment = Alignment.Center,
        ){
//            Text("Scaffold Body", fontSize = 25.sp)
        }

        Poster(movie = movie, navController = navController)

        Content(verticalScrollState = verticalScrollState, horizontalScrollState = horizontalScrollState, movie = movie, navController = navController)


    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable()
fun PreviewMovieDetailsScreen() {
    MovieDetailsScreen(navController = rememberNavController(), movie = moreLikeThis[1])
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
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Content(verticalScrollState: ScrollState, horizontalScrollState: ScrollState, movie: MovieModel, navController: NavController) {
    Box(
        modifier = Modifier
            .verticalScroll(verticalScrollState)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = 1300f,
                    endY = 1600f,
                )
            )
            .padding(bottom = 60.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 520.dp)
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

            MoreLikeThisSection(navController = navController)
        }
    }
}

// Title and Info section
@Composable()
fun TitleAndInfo(movie: MovieModel) {
//    Genre
    val lastGenre = movie.genre?.lastIndex

    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 5.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        movie.genre?.let { it ->
            items(it.size) {
                Text(text = movie.genre[it].name, modifier = Modifier.padding(horizontal = 10 .dp))
                if (it != lastGenre) {
                    Box(modifier = Modifier
                        .size(5.dp)
                        .background(Color.White, CircleShape))
                }
            }
        }
    }
    //                Title
    Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp), contentAlignment = Alignment.Center) {
        Text(text = movie.title, fontSize = 20.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
    }

//                Info
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Text(text = movie.year.toString(), fontWeight = FontWeight.Normal, modifier = Modifier.padding(horizontal = 10 .dp))
        Box(modifier = Modifier
            .size(5.dp)
            .background(Color.White, CircleShape))
        movie.duration?.let { duration ->
            Text(
                text = formatDuration(duration),
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 10 .dp)
            )
        }
    }
}

// Play and Download button
@RequiresApi(Build.VERSION_CODES.O)
@Composable()
fun PlayAndDownloadButtons(movie: MovieModel) {
//Play Button
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .height(50.dp)
            .padding(top = 10.dp)
            .padding(horizontal = 50.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        color = Color.White,
        contentColor = Color.Black,
        onClick = { }
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

//Download Button
    Surface(
        modifier = Modifier
            .height(50.dp)
            .padding(top = 10.dp)
            .padding(horizontal = 50.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        color = Color.DarkGray,
        contentColor = Color.Gray,
        onClick = {
            Toast.makeText( context,
                "Downloading...",
                Toast.LENGTH_SHORT ).show()
        }
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(model = R.drawable.download_icon_gray, contentDescription = null, modifier = Modifier.size(30.dp))
            Text(text = "Download", fontWeight = FontWeight.Medium, modifier = Modifier.padding(start = 5.dp))
        }
    }
}

// Descriptions
@Composable()
fun DescriptionsSection(movie: MovieModel) {
    Box(
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Text(text = movie.description, style = TextStyle(lineHeight = 23.sp))
    }
}

// Trailer
@Composable()
fun TrailerSection(movie: MovieModel) {
    Column(modifier = Modifier.width(180.dp)) {
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
        Text(text = movie.title + "'s Trailer", style = TextStyle(lineHeight = 20.sp))
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
                Column(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .width(180.dp)
                ) {
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
                    Text(text = "The making of " + movie.title, style = TextStyle(lineHeight = 20.sp))
                }

                Column(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .width(180.dp)
                ) {
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

                Column(
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .width(180.dp)
                ) {
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
                    Text(text = "Behind the Scene")
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
        Text(text = "Cast & Crew", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Box(modifier = Modifier.padding(top = 10.dp)) {
            LazyRow {
                items(cast.size) {
                    Column(
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .width(100.dp),
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
                        Text(text = cast[it].actorName, modifier = Modifier.padding(top = 5.dp), textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

// Bonus Content
@RequiresApi(Build.VERSION_CODES.O)
@Composable()
fun MoreLikeThisSection(navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        Text(text = "More Like This", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Box {
            LazyRow {
                items(moreLikeThis.size) {
                    Surface(
                        modifier = Modifier.width(110.dp).height(170.dp).padding(vertical = 10.dp).padding(horizontal = 5.dp),
                        shape = RoundedCornerShape(1.dp),
                        onClick = {
                            navController.navigate("movie-details/${moreLikeThis[it].title}")
                        }
                    ) {
                        AsyncImage(model = moreLikeThis[it].image, contentDescription = null, contentScale = ContentScale.Crop)
                    }
                }
            }
        }
    }
}
