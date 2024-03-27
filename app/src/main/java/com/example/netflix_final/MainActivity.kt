package com.example.netflix_final

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.netflix_final.models.movieList
import com.example.netflix_final.screens.FirstTimeScreen
import com.example.netflix_final.screens.HomeScreen
import com.example.netflix_final.screens.SignInScreen
import com.example.netflix_final.screens.TitleDiveDeepScreen
import com.example.netflix_final.screens.WhoIsWatchingScreen
import com.example.netflix_final.ui.theme.NetflixFinalTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeNavScreen()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ComposeNavScreen() {
    val navController = rememberNavController()

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
            HomeScreen(navController = navController)
        }
        composable(
            "movie-details/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val selectedMovie = movieList.first {it.title == title}
            TitleDiveDeepScreen(navController = navController, movie = selectedMovie);
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