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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.netflix_final.Starter.FirstApp
import com.example.netflix_final.Starter.FourthApp
import com.example.netflix_final.Starter.Login
import com.example.netflix_final.Starter.SecondApp
import com.example.netflix_final.Starter.ThirdApp
import com.example.netflix_final.ui.theme.NetflixFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    previewApp()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewApp() {
    NavScreen()
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