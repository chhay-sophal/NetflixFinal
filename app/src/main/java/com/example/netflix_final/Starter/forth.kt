package com.example.netflix_final.Starter


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.netflix_final.R

@Composable
fun FourthApp(navController: NavController) {
    BodyFourth()
    Header()
    val Light = FontFamily(Font(R.font.netflixsans_light))

    Row(
        modifier = Modifier.padding(start = 150.dp, top = 735.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.icon),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(R.drawable.icon),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(R.drawable.icon),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(R.drawable.icon_red),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
        )
    }
    Row(){
        Surface(
            color = Color.Red,
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(start = 0.dp, top = 770.dp)
                .height(70.dp)
        ) {
            Text(
                text = "SIGN IN",
                fontFamily = Light,
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 12.dp)
                    .clickable {
                        // Navigate to the sign-in screen
                        navController.navigate("Login")
                    }
            )
        }
    }

}



@Composable
fun BodyFourth(){
    val Bold = FontFamily(Font(R.font.netflixsans_bold))
    val Light = FontFamily(Font(R.font.netflixsans_regular))

    Box {
        Row{
            Image(
                modifier = Modifier
                    .padding(0.dp,0.dp,0.dp,0.dp)
                    .fillMaxSize()
                    .fillMaxHeight()

                ,
                painter = painterResource(R.drawable.getstart),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

        }
        Text(text = "How do I watch?",
            color = Color.White,
            fontFamily = Bold,
            fontSize = 45.sp,
            lineHeight = 45.sp * 1.2f,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 300.dp, 0.dp, 0.dp)
        )

        Text(text = "Members that subscribe to  Netflix can watch here in the    " +
                "app",
            fontFamily = Light,
            lineHeight = 28.sp * 1.2f,
            color = Color.White,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 410.dp, 0.dp, 0.dp)
        )
        Text(
            fontFamily = Light,
            text = "Create a Netflix account and",
            lineHeight = 28.sp * 1.2f,
            color = Color.White,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 550.dp, 0.dp, 0.dp)
        )
        Text(
            fontFamily = Light,
            text = " more at",
            lineHeight = 28.sp * 1.2f,
            color = Color.White,
            fontSize = 25.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxSize()
                .padding(59.dp, 585.dp, 0.dp, 0.dp)
        )
        Text(
            fontFamily = Light,
            text = "netflix.com/more",
            lineHeight = 28.sp * 1.2f,
            color = Color.Blue,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(110.dp, 585.dp, 0.dp, 0.dp)
        )

    }

}
