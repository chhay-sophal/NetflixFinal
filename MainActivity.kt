package com.example.myapplication


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    app()
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun previewApp() {
    app()
}


@Composable
fun app() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
    ) {
        composeText()
    }
}

@Composable
fun composeText() {
    Surface(shape = RoundedCornerShape(0.dp), modifier = Modifier.background(Color.Black), color=Color.Black) {
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            ) {
                Box(contentAlignment = Alignment.Center) {
                    // Your Image
                    Image(
                        painter = painterResource(R.drawable.topgun),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )

                    IconButton(
                        onClick = {  },
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(1.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    // Your Play Icon Overlay
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.Black.copy(alpha = 0.5f), shape = CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                            .padding(8.dp)
                            .align(Alignment.Center),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier.size(40.dp),
                            tint = Color.White
                        )
                    }
                }
            }
            ImageGallery(LazyListState())
        }
    }
}



@Composable
fun composeImageCard() {
            var showMyListAlert by remember { mutableStateOf(false) }
            var showRateAlert by remember { mutableStateOf(false) }
            var showShareAlert by remember { mutableStateOf(false) }

            // Function to display the AlertDialog based on the state variables
            if (showMyListAlert) {
                AlertDialog(
                    onDismissRequest = { showMyListAlert = false },
                    title = { Text(text = "My List") },
                    text = { Text(text = "Added to list") },
                    confirmButton = {
                        Button(onClick = { showMyListAlert = false }) {
                            Text("OK")
                        }
                    }
                )
            }

            if (showRateAlert) {
                AlertDialog(
                    onDismissRequest = { showRateAlert = false },
                    title = { Text(text = "Rate") },
                    text = { Text(text = "Rated Successfully") },
                    confirmButton = {
                        Button(onClick = { showRateAlert = false }) {
                            Text("OK")
                        }
                    }
                )
            }

            if (showShareAlert) {
                AlertDialog(
                    onDismissRequest = { showShareAlert = false },
                    title = { Text(text = "Share") },
                    text = { Text(text = "Shared Successfully") },
                    confirmButton = {
                        Button(onClick = { showShareAlert = false }) {
                            Text("OK")
                        }
                    }
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Top Gun: Maverick",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White


                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "New",
                        color = Color.Green,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        "2022",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(RectangleShape)
                            .background(Color.LightGray)
                            .padding(2.dp)
                    ) {
                        Text(
                            "13+",
                            style = TextStyle(color = Color.Black, fontSize = 10.sp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        "2h 11m",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(RectangleShape)
                            .background(Color.Black)
                            .border(
                                1.dp,
                                Color.Gray,
                                RectangleShape
                            )
                            .padding(5.dp)
                    ) {
                        Text(
                            "HD",
                            style = TextStyle(color = Color.White, fontSize = 10.sp)
                        )
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                Color.Red,
                                shape = RectangleShape
                            )
                            .padding(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ThumbUp,
                            contentDescription = "Liked",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Most Liked",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White // Text color
                    )
                }

                Spacer(modifier = Modifier.height(10.dp)) // Space before the button
                // Assuming you want the buttons to follow
                Button(
                    onClick = { /*TODO: Implement play action*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 1.dp, vertical = 1.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Icon(Icons.Filled.PlayArrow, contentDescription = "Play", tint = Color.Black)
                    Text("Play", color = Color.Black)
                }
                Button(
                    onClick = { /*TODO: Implement download action*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 1.dp, vertical = 1.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    shape = RoundedCornerShape(4.dp)

                ) {
                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowDown,
                        contentDescription = "Download",
                        tint = Color.White
                    )
                    Text("Download", color = Color.White)
                }
                Text(
                    "After more than 30 years as one of the Navy's top aviators, Maverick is as daring as ever, training a new class of Top Gun graduates for a specialized mission the likes of which no living pilot has ever seen.",
                    fontSize = 15.sp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    "Cast: Tom Cruise, Miles Teller, Val Kilmer, Jennifer Connelly",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    "Director: Joseph Kosinski",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {

                    Column(horizontalAlignment = Alignment.Start) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            contentDescription = "My List",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                                .clickable { showMyListAlert = true },
                        )
                        Text(
                            text = "My List",
                            color = Color.Gray
                        )
                    }

                    // Icon for "Rate"
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Rounded.ThumbUp,
                            contentDescription = "Rate",
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                                .clickable { showRateAlert = true },
                        )
                        Text(
                            text = "Rate",
                            color = Color.Gray
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.send),
                            contentDescription = "Share",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                                .clickable { showShareAlert = true },
                        )
                        Text(
                            text = "Share",
                            color = Color.Gray
                        )
                    }
                }
                Text(
                    text = "More Like This",
                    color = Color.LightGray,
                    fontWeight = FontWeight(500)
                )

            }
        }



@Composable
fun ImageGallery(lazyListState: LazyListState) {
    val images = listOf(
        R.drawable.avatar,
        R.drawable.bladerunner,
        R.drawable.damsel,
        R.drawable.queengambit,
        R.drawable.io,
        R.drawable.slumber,
        R.drawable.barbie,
        R.drawable.lord,
        R.drawable.falcon,
        R.drawable.spidey,
        R.drawable.homealone,
        R.drawable.life
    )

    val rows = images.windowed(size = 3, step = 3, partialWindows = true)

    LazyColumn(state = lazyListState) {
        item {
            composeImageCard()
        }

        items(rows) { rowImages ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                rowImages.forEach { imageRes ->
                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .padding(2.dp)
                            .aspectRatio(1f)
                    )
                }


                if (rowImages.size < 3) {
                    repeat(3 - rowImages.size) {
                        Spacer(modifier = Modifier
                            .weight(1f)
                            .padding(2.dp))
                    }
                }
            }
        }
    }
}










