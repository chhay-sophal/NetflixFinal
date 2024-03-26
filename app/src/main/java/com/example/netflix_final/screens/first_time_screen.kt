package com.example.netflix_final.screens

import android.content.ClipData.Item
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.netflix_final.R
import java.time.Duration
import java.time.Year

@OptIn(ExperimentalFoundationApi::class)
@Composable()
fun FirstTimeScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            Modifier.fillMaxSize()
        ) {
//            Header
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = R.drawable.netflix_logo,
                        contentDescription = "Netflix Logo"
                    )
                }
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Row() {
                        Text(text = "Privacy", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Light)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Sign In", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Light)
                    }
                }
            }

            val pagerState = rememberPagerState(pageCount = { textList.size }
            )

            Box(modifier = Modifier.weight(1f)) {
                ComposeHorizontalPager(pagerState)
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    (0 until pagerState.pageCount).forEach {index ->
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    color = if (index == pagerState.currentPage) Color.Red else Color.White,
                                    shape = CircleShape
                                )
                            )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { navController.navigate("sign-in") },
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(0.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "SIGN IN", color = Color.White)
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FirstScreenPreview() {
    FirstTimeScreen(navController = rememberNavController());
}

data class FirstScreenText(val title: String, val firstText: String, val secondText: String)

val textList: MutableList<FirstScreenText> = mutableListOf(
    FirstScreenText("Watch everywhere", "Stream on your phone, tablet, laptop and TV.", "Create a Netflix account and more at netflix.com/more"),
    FirstScreenText("There's a plan for every fan", "Small price. Big entertainment.", "Create a Netflix account and more at netflix.com/more"),
    FirstScreenText("Cancel online anytime", "Join today, no reason to wait.", "Create a Netflix account and more at netflix.com/more"),
    FirstScreenText("How do I watch?", "Members that subscribe to Netflix can watch here in the app.", "Create a Netflix account and more at netflix.com/more"),
)

@OptIn(ExperimentalFoundationApi::class) @Composable
fun ComposeHorizontalPager(pagerState: PagerState) {

    HorizontalPager(state = pagerState) {
        Box(
            modifier = Modifier
                .padding(40.dp)
                .width(300.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = textList[pagerState.currentPage].title,
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = textList[pagerState.currentPage].firstText,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = textList[pagerState.currentPage].secondText,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}
