package com.example.netflix_final.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableTopAppBar(navController: NavController, titleText: String) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Rounded.KeyboardArrowLeft, contentDescription = "Back", modifier = Modifier.size(40.dp))
            }
        },
        title = {
            Text(text = titleText, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.LightGray)
        },
        colors = topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.LightGray,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
        actions = { },
    )
//    TopAppBar( navigationIcon = {
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(Icons.Rounded.Menu, contentDescription = "Menu") }
//    },
//        title = { Text("កម#វ%ធីែខ#រេយើង") },
//        colors = topAppBarColors(
//            containerColor = Color(0xFFE91E63), titleContentColor = Color.White, navigationIconContentColor = Color.White, actionIconContentColor = Color.White,
//        ),
//        actions = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(Icons.Rounded.Share, contentDescription = "Share") }
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(Icons.Rounded.Settings, contentDescription = "Settings") }
//        }
//    )
}