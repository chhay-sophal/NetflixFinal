package com.example.netflix_final.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.netflix_final.R
import com.example.netflix_final.components.ComposableBottomAppBar
import com.example.netflix_final.models.MovieModel
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
//
//@Composable
//fun Profile(navController: NavController){
//    Scaffold(
//        bottomBar = { ComposableBottomAppBar(navController) }
//    ){ paddingValues ->
//        Box(
//            modifier = Modifier
//                .padding(paddingValues)
//                .fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ){
//            ProfileContent()
//        }
//    }
//}
@Composable
fun Profile() {
    val scrollState = rememberScrollState()
//    Box(
//        modifier = Modifier
//        .verticalScroll(scrollState)
//    )
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ){
        Column {
            TopProfile()
            Spacer(modifier = Modifier.width(20.dp))
            Notification()
            Spacer(modifier = Modifier.width(20.dp))
            MovieList()
            Downloads()
            Spacer(modifier = Modifier.height(10.dp))
            Tvshow()
        }

    }


//    Column(
//
//      ) {
//          TopProfile()
//          Spacer(modifier = Modifier.width(20.dp))
//          Notification()
//          Spacer(modifier = Modifier.width(20.dp))
//          MovieList()
//          Downloads()
//          Spacer(modifier = Modifier.height(10.dp))
//          Tvshow()
//      }
}
@Composable
fun Tvshow(){
    Column(
    )
        {

        Row(
            modifier = Modifier.padding(start=30.dp, top = 20.dp)
        )
        {
            Text(
                text = "TV Shows & Movies You've Liked",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
            Column {
                AsyncImage(
                    model = R.drawable.life,
                    contentDescription = "N Logo",
                    modifier = Modifier
                        .size(200.dp)
                )
                Surface(
                    modifier = Modifier.padding(start = 30.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .width(140.dp)
                            .clip(RoundedCornerShape(15.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(){
                            AsyncImage(
                                model = R.drawable.icsend,
                                contentDescription = "N Logo",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .padding(start = 5.dp),
                            )
                            Text(
                                text = "Share",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 5.dp, start = 5.dp),
                            )
                        }
                    }
                }

            }
    }

}
@Composable
fun TopProfile(){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "My Netflix",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(100.dp))
        Text(
            text = "icon",
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "icon",
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "icon",
            color = Color.White,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
        )
    }
    Box(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        AsyncImage(
            model = R.drawable.kids,
            contentDescription = "N Logo",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
        )
        Row(
            modifier = Modifier.padding(top = 135.dp)
        ) {
            Text(
                text = "Jenny", color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "icon", color = Color.White,
                modifier = Modifier.padding(top = 15.dp)
            )
        }
    }
}
@Composable
fun Notification(){
    Row(
        modifier = Modifier.padding(top = 0.dp, start = 10.dp)
    ) {
        AsyncImage(
            model = R.drawable.kids,
            contentDescription = "N Logo",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Notifications",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            model = R.drawable.kids,
            contentDescription = "N Logo",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        )
    }
}

@Composable
fun Downloads(){
    Row(
        modifier = Modifier.padding(top = 25.dp, start = 10.dp)
    ) {
        AsyncImage(
            model = R.drawable.kids,
            contentDescription = "N Logo",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Download",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
            model = R.drawable.kids,
            contentDescription = "N Logo",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        )
    }
}

@Composable
fun MovieList() {
    data class Model(val image: Int, val topic: String, val des: String,val date: String)

    val models = arrayOf(
        Model(R.drawable.netflix, "Coming Marth 30th", "Get a first look today.","Today"),
        Model(R.drawable.netflix2, "Coming March 29th", "Play the Trailer","Yesterday"),
    )
    LazyColumn {
        items(models.size) { index ->
            val models = models[index]
            Row(
                modifier = Modifier.padding(top=13.dp,start=5.dp)
            ) {
                Surface(
                    modifier = Modifier.padding(5.dp),
                    shape = RoundedCornerShape(5.dp),
                ) {
                    AsyncImage(
                        model = models.image,
                        contentDescription = "Movie Image",
                        modifier = Modifier
                            .width(160.dp)
                            .height(90.dp)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
//                    shape = RoundedCornerShape(20.dp),
                    )
                }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = models.topic,
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 15.dp)
                        )
                        Text(
                            text = models.date,
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(top = 1.dp)
                        )
                        Text(
                            text = models.date,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top = 1.dp)
                        )
                    }
                }
            }
        }
    }



