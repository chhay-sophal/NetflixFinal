package com.example.netflix_final.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
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
import com.example.netflix_final.models.myList

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyListScreen(navController: NavController) {
    Scaffold(
        bottomBar = { ComposableBottomAppBar(navController) }
    ){ paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Black),
            color = Color.Black,
            contentColor = Color.White,
        ){
            MyListScreenContent(navController = navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true)
@Composable
fun PreviewMyListScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "my-list") {
        composable("my-list") {
            MyListScreen(navController = navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyListScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Text(text = "My List", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.LightGray, modifier = Modifier.padding(bottom = 10.dp))

        for (i in 0 until myList.size step 2) {
            Row(modifier = Modifier
                .height(150.dp)
                .padding(10.dp)) {
                // Display the first movie in the row
                Surface(
                    modifier = Modifier
                        .width(170.dp)
                        .padding(horizontal = 3.dp),
                    color = Color.Transparent,
                    contentColor = Color.White,
                    onClick = {
                        navController.navigate("movie-details/${myList[i].title}")
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
                                model = myList[i].image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Text(
                            text = myList[i].title,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1
                        )
                    }
                }

                if (i + 1 < myList.size) {
                    Surface(
                        modifier = Modifier
                            .width(170.dp)
                            .padding(horizontal = 3.dp),
                        color = Color.Transparent,
                        contentColor = Color.White,
                        shape = RoundedCornerShape(10.dp),
                        onClick = {
                            navController.navigate("movie-details/${myList[i + 1].title}")
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
                                    model = myList[i + 1].image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(
                                text = myList[i + 1].title,
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
