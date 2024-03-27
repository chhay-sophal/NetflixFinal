package com.example.netflix_final.Starter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
fun Header(){
    val Regular = FontFamily(Font(R.font.netflixsans_regular))

    Box(){
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 16.dp)
        )
        {
            Image(
                modifier = Modifier
                    .width(120.dp)
                ,
                painter = painterResource(R.drawable.r),
                contentDescription = null
            )
            Text(
                fontFamily = Regular,
                text = "Privacy  Help",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(147.dp,16.dp,0.dp,0.dp)
            )


        }

    }

}

@Composable
fun FooterSecond() {
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
            painter = painterResource(R.drawable.icon_red),
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
    }
    Row(){
        Surface(
            color = Color.Red,
            shape = RoundedCornerShape(3.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(start = 0.dp, top = 770.dp)
                .height(70.dp)
        ) {
            Text(text = "SIGN IN", fontFamily = Light ,
                fontSize = 20.sp ,
                color = Color.White,
                textAlign = TextAlign.Center ,
                modifier = Modifier.padding(top = 12.dp))
//
        }
    }

}

@Composable
fun FooterThird() {
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
            painter = painterResource(R.drawable.icon_red),
            contentDescription = null,
            modifier = Modifier.width(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(R.drawable.icon),
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
            Text(text = "SIGN IN", fontFamily = Light ,
                fontSize = 20.sp ,
                color = Color.White,
                textAlign = TextAlign.Center ,
                modifier = Modifier.padding(top = 12.dp))
//
        }
    }

}

@Composable
fun FooterFourth() {
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
            Text(text = "SIGN IN", fontFamily = Light ,
                fontSize = 20.sp ,
                color = Color.White,
                textAlign = TextAlign.Center ,
                modifier = Modifier.padding(top = 12.dp))
//
        }
    }

}