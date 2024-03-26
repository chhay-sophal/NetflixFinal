package com.example.netflix_final

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.netflix_final.screens.FirstTimeScreen
import com.example.netflix_final.screens.SignInScreen
import com.example.netflix_final.ui.theme.NetflixFinalTheme

class MainActivity : ComponentActivity() {
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
//        composable(
//            "detail/{movieName}",
//            arguments = listOf(navArgument("movieName") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val movieName = backStackEntry.arguments?.getString("movieName")
//            val selectedMovie = movieList1.first {it.name == movieName}
//            DetailScreen(navController, selectedMovie);
//        }
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