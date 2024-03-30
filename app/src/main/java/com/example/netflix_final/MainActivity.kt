package com.example.netflix_final

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.netflix_final.models.movieList

import com.example.netflix_final.Starter.FirstApp
import com.example.netflix_final.Starter.FourthApp
import com.example.netflix_final.Starter.Login
import com.example.netflix_final.Starter.SecondApp
import com.example.netflix_final.Starter.ThirdApp
import com.example.netflix_final.models.featureMovies

import com.example.netflix_final.screens.FirstTimeScreen
import com.example.netflix_final.screens.HomeScreen
import com.example.netflix_final.screens.SignInScreen
import com.example.netflix_final.screens.MovieDetailsScreen
import com.example.netflix_final.screens.MyListScreen
import com.example.netflix_final.screens.PlayingScreen
import com.example.netflix_final.screens.SettingsScreen
import com.example.netflix_final.screens.WhoIsWatchingScreen

import com.example.netflix_final.ui.theme.NetflixFinalTheme
import com.example.netflix_final.screens.SearchScreen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    ComposeNavScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ComposeNavScreen() {
    val navController = rememberNavController()
    val featureFilmsPagerState = rememberPagerState( pageCount = { featureMovies.size } )
    val homePageScrollState = rememberScrollState()

    NavHost(navController = navController, startDestination = "first-screen") {
        composable("first-screen") {
            FirstTimeScreen(navController = navController)
        }
        composable("sign-in") {
            SignInScreen(navController = navController)
        }
        composable("who-is-watching") {
            WhoIsWatchingScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController, featureFilmsPagerState, homePageScrollState)
        }
        composable(
            "movie-details/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val selectedMovie = movieList.first {it.title == title}
            MovieDetailsScreen(navController = navController, movie = selectedMovie);
        }
        composable("my-list") {
            MyListScreen(navController = navController)
        }
        composable("settings") {
            SettingsScreen(navController = navController)
        }
        composable(
            "play/{title}" ,
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) {backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val selectedMovie = movieList.first {it.title == title}
            PlayingScreen(navController = navController, movie = selectedMovie)
        }
//        composable(
//            "detail/{movieName}",
//            arguments = listOf(navArgument("movieName") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val movieName = backStackEntry.arguments?.getString("movieName")
//            val selectedMovie = movieList1.first {it.name == movieName}
//            DetailScreen(navController, selectedMovie);
//        }

        composable("search"){
            SearchScreen(navController = navController)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetflixFinalTheme {
        Greeting("Android")
    }
}
@Composable
fun NavScreen(){
    val  navController = rememberNavController()
    NavHost(navController = navController, startDestination = "First"){
        composable("first"){
            FirstApp(navController=navController)
        }
        composable("Second"){
            SecondApp(navController=navController)
        }
        composable("Third"){
            ThirdApp(navController=navController)
        }

        composable("Fourth"){
            FourthApp(navController=navController)
        }
        composable("Login"){
            Login()
        }
    }
}