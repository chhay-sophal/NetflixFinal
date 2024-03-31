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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.R
import com.example.netflix_final.components.ComposableBottomAppBar
import com.example.netflix_final.components.ComposableTopAppBar
import com.example.netflix_final.models.featureMovies
import com.example.netflix_final.models.likeDune
import com.example.netflix_final.models.loggedInUser
import com.example.netflix_final.models.moreLikeThis
import com.example.netflix_final.models.myList

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileScreen(navController: NavController){
    Scaffold(
        bottomBar = { ComposableBottomAppBar(navController) },
    ){ paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black),
            color = Color.Black,
            contentColor = Color.White,
        ){
            ProfileContent(navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(navController = rememberNavController())
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProfileContent(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Text(
            text = "Profile",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.LightGray,
            modifier = Modifier.padding(bottom = 10.dp, start = 15.dp)
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ){
            Column {
                TopProfile()
                Spacer(modifier = Modifier.width(20.dp))
                Notification(navController)
                Spacer(modifier = Modifier.width(20.dp))
                MyList(navController)
                Spacer(modifier = Modifier.width(20.dp))
                Downloads(navController)
                Spacer(modifier = Modifier.height(10.dp))
                TVShows(navController)
                Spacer(modifier = Modifier.width(20.dp))
                MovieList()
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TVShows(navController: NavController){
    Column(
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Text(
            text = "TV Shows & Movies You've Liked",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top =20.dp)
        )
        LazyRow(Modifier.padding(top = 10.dp)) {
            items(featureMovies.size) {
                Column(
                    Modifier
                        .width(110.dp)
                        .padding(end = 10.dp)) {
                    Surface(onClick = { navController.navigate("movie-details/${featureMovies[it]?.title}") }) {
                        AsyncImage(
                            model = featureMovies[it]?.image,
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Surface(modifier = Modifier.height(30.dp).fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .background(Color.DarkGray)
                                .fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                                val context = LocalContext.current
                                Surface(
                                    color = Color.Transparent,
                                    onClick = {
                                        Toast.makeText( context,
                                            "Shared",
                                            Toast.LENGTH_SHORT ).show()
                                    }
                                ) {
                                    AsyncImage(
                                        model = R.drawable.icsend,
                                        contentDescription = "Share",
                                        modifier = Modifier.padding(3.dp)
                                    )
                                }
                                Text(
                                    text = "Share",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
        }

        Text(
            text = "Trailers You've Watched",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top =20.dp)
        )
        LazyRow(Modifier.padding(top = 10.dp)) {
            items(featureMovies.size) {
                Column(
                    Modifier
                        .width(110.dp)
                        .padding(end = 10.dp)) {
                    Surface(onClick = { navController.navigate("movie-details/${featureMovies[it]?.title}") }) {
                        AsyncImage(
                            model = featureMovies[it]?.image,
                            contentDescription = "N Logo",
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        Text(
            text = "Continue Watching",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 20.dp)
        )
        LazyRow {
            items(likeDune.size) {
                likeDune[it]?.let { it1 -> MovieBox(navController = navController, movie = it1) }
            }
        }

        Text(
            text = "Recently Watched",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 20.dp)
        )
        LazyRow {
            items(myList.size) {
                Surface(
                    modifier = Modifier
                        .width(170.dp)
                        .padding(horizontal = 3.dp)
                        .padding(top = 10.dp),
                    color = Color.Transparent,
                    contentColor = Color.White,
                    onClick = {
                        navController.navigate("movie-details/${myList[it]?.title}")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), shape = RoundedCornerShape(10.dp), color = Color.Gray) {
                            AsyncImage(
                                model = myList[it]?.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        myList[it]?.let {
                            Text(
                                text = it.title,
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

        Text(
            text = "Go Behind the Scenes",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 20.dp)
        )
        LazyRow {
            items(myList.size) {
                Surface(
                    modifier = Modifier
                        .width(170.dp)
                        .padding(horizontal = 3.dp)
                        .padding(top = 10.dp),
                    color = Color.Transparent,
                    contentColor = Color.White,
                    onClick = {
                        navController.navigate("movie-details/${myList[it]?.title}")
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp), shape = RoundedCornerShape(10.dp), color = Color.Gray) {
                            AsyncImage(
                                model = myList[it]?.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        myList[it]?.let {
                            Text(
                                text = it.title,
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

@Composable
fun TopProfile(){
    Box(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        AsyncImage(
            model = loggedInUser.profile,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
        )
        Box(
            modifier = Modifier
                .padding(top = 135.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = loggedInUser.name, color = Color.LightGray,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Notification(navController: NavController){
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Surface(
            color = Color.Transparent,
            onClick = {
                navController.navigate("profile/notifications")
            }
        ) {
            Row(
                modifier = Modifier.padding(top = 0.dp, start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    color = Color.Red,
                    shape = CircleShape
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Notifications Icon")
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Notifications",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "Go to notifications page")
                }
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp),
            color = Color.Transparent,
            onClick = {}
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(140.dp)
                        .padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    AsyncImage(model = "https://image.tmdb.org/t/p/original/rqeGrcvTK1BRqjEN0gScsYegA4c.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                }
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Text(text = "Coming March 30th", fontWeight = FontWeight.Bold)
                    Text(text = "Get a first look today.", fontSize = 13.sp)
                    Text(text = "Today", fontSize = 10.sp, color = Color.LightGray)
                }
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp),
            color = Color.Transparent,
            onClick = {}
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(140.dp)
                        .padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    AsyncImage(model = "https://www.joblo.com/wp-content/uploads/2024/01/godzilla-x-kong-arm-1280x720.jpg", contentDescription = null, contentScale = ContentScale.Crop)
                }
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Text(text = "Coming March 29th", fontWeight = FontWeight.Bold)
                    Text(text = "Play the trailer", fontSize = 13.sp)
                    Text(text = "Yesterday", fontSize = 10.sp, color = Color.LightGray)
                }
            }
        }
    }
}

@Composable
fun Downloads(navController: NavController){
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Surface(
            color = Color.Transparent,
            onClick = {
                navController.navigate("profile/downloads")
            }
        ) {
            Row(
                modifier = Modifier.padding(top = 0.dp, start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    color = Color.Blue,
                    shape = CircleShape,
                    onClick = {
                        navController.navigate("profile/downloads")
                    }
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        AsyncImage(model = R.drawable.download_icon_white, contentDescription = "Downloads Icon", modifier = Modifier.size(20.dp))
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Downloads",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "Go to downloads page")
                }
            }
        }
    }
}

@Composable
fun MyList(navController: NavController){
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Surface(
            color = Color.Transparent,
            onClick = {
                navController.navigate("profile/my-list")
            }
        ) {
            Row(
                modifier = Modifier.padding(top = 0.dp, start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    color = Color.Magenta,
                    shape = CircleShape,
                    onClick = {
                        navController.navigate("profile/my-list")
                    }
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Icon(imageVector = Icons.Rounded.List, contentDescription = "List Icon")
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "My List",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowRight, contentDescription = "Go to downloads page")
                }
            }
        }
    }
}


@Composable
fun MovieList() {
    data class Model(val image: Int, val topic: String, val des: String,val date: String)

    val models = arrayOf(
        Model(R.drawable.netflix, "Coming Marth 30th", "Get a first look today.","Today"),
        Model(R.drawable.netflix2, "Coming March 29th", "Play the Trailer","Yesterday"),
    )
//    LazyColumn {
//        items(models.size) { index ->
//            val models = models[index]
//            Row(
//                modifier = Modifier.padding(top=13.dp,start=5.dp)
//            ) {
//                Surface(
//                    modifier = Modifier.padding(5.dp),
//                    shape = RoundedCornerShape(5.dp),
//                ) {
//                    AsyncImage(
//                        model = models.image,
//                        contentDescription = "Movie Image",
//                        modifier = Modifier
//                            .width(160.dp)
//                            .height(90.dp)
//                            .fillMaxSize(),
//                        contentScale = ContentScale.Crop,
////                    shape = RoundedCornerShape(20.dp),
//                    )
//                }
//                    Spacer(modifier = Modifier.width(10.dp))
//                    Column {
//                        Text(
//                            text = models.topic,
//                            color = Color.White,
//                            fontSize = 17.sp,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier.padding(top = 15.dp)
//                        )
//                        Text(
//                            text = models.date,
//                            color = Color.White,
//                            fontSize = 15.sp,
//                            fontWeight = FontWeight.Normal,
//                            modifier = Modifier.padding(top = 1.dp)
//                        )
//                        Text(
//                            text = models.date,
//                            color = Color.White,
//                            fontSize = 13.sp,
//                            fontWeight = FontWeight.Light,
//                            modifier = Modifier.padding(top = 1.dp)
//                        )
//                    }
//                }
//            }
//        }
    }



