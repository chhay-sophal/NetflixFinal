package com.example.netflix_final.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.netflix_final.R

@Composable
fun ComposableBottomAppBar(navController: NavController) {
    val currentRoute = navController.currentDestination?.route
    BottomAppBar(
        containerColor = Color.Black, contentColor = Color.White,
        actions = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        navController.navigate("home")
                    }) {
                        val iconColor = if (currentRoute == "home") Color.Red else Color.White
                        Icon(Icons.Rounded.Home, contentDescription = "Home", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        navController.navigate("search")
                    }) {
                        val iconColor = if (currentRoute == "search") Color.Red else Color.White
                        Icon(Icons.Rounded.Search, contentDescription = "Search", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        navController.navigate("my-list")
                    }) {
                        val iconColor = if (currentRoute == "my-list") Color.Red else Color.White
                        Icon(Icons.Rounded.List, contentDescription = "List", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        navController.navigate("download")
                    }) {
                        if (currentRoute == "download") {
                            AsyncImage(model = R.drawable.download_icon_red, contentDescription = null, modifier = Modifier.size(17.dp))
                        } else {
                            AsyncImage(model = R.drawable.download_icon_white, contentDescription = null, modifier = Modifier.size(17.dp))
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        val iconColor = if (currentRoute == "profile") Color.Red else Color.White
                        Icon(Icons.Rounded.Person, contentDescription = "Profile", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        navController.navigate("settings")
                    }) {
                        val iconColor = if (currentRoute == "settings") Color.Red else Color.White
                        Icon(Icons.Rounded.Settings, contentDescription = "Settings", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        },
        modifier = Modifier.height(50.dp)
    )
}