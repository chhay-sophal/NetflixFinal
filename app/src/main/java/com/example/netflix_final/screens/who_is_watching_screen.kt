package com.example.netflix_final.screens

import android.widget.Toast
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.R
import com.example.netflix_final.models.loggedInUser
import com.example.netflix_final.models.userList

@Composable
fun WhoIsWatchingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row (
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.weight(2f))

                Box(
                    Modifier.height(70.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Who is watching?", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.weight(1f))

                val context = LocalContext.current
                Surface(
                    modifier = Modifier.height(70.dp),
                    color = Color.Black,
                    onClick = {
                        Toast.makeText( context,
                            "You have clicked edit button.",
                            Toast.LENGTH_SHORT ).show()
                    }
                ){
                    Box(
                        Modifier.fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Edit", color = Color.White)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            contentAlignment = Alignment.Center
        ) {
            ComposeLazyVerticalGridFix(navController)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWhoIsWatchingScreen() {
    WhoIsWatchingScreen(navController = rememberNavController())
}

@Composable
fun ComposeLazyVerticalGridFix(navController: NavController) {
    val isLastRowWithOneItem = userList.size % 2 != 0
    if (isLastRowWithOneItem) {
        Column() {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items(userList.size - 1) { index ->
                    Button(
                        onClick = {
                            loggedInUser = userList[index]
                            navController.navigate("home")
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(0.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = userList[index].profile,
                                contentDescription = "Profile Image",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color.Red)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = userList[index].name, color = Color.White)
                        }
                    }
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
            ) {
                items(1) {
                    Button(
                        onClick = {
                            loggedInUser = userList[userList.lastIndex]
                            navController.navigate("home")
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(0.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = userList[userList.lastIndex].profile,
                                contentDescription = "Profile Image",
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = userList[userList.lastIndex].name, color = Color.White)
                        }
                    }
                }
            }
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            items(userList.size) { index ->
                Button(
                    onClick = {
                        loggedInUser = userList[userList.lastIndex]
                        navController.navigate("home")
                    },
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier
                        .size(120.dp, 135.dp)
                        .padding(10.dp)
                        .fillMaxWidth(),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = userList[index].profile,
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .size(90.dp, 90.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = userList[index].name, color = Color.White)
                    }
                }
            }
        }
    }
}