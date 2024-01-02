package com.pragyanspace.campushive

import android.R
import android.R.id
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.pragyanspace.campushive.ui.theme.CampusHiveTheme


class LaunchActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedTab by remember { mutableStateOf(0) }
            CampusHiveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar() {
                                NavigationBarItem(
                                    selected = selectedTab == 0,
                                    onClick = { selectedTab = 0 },
                                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                                    label = { Text("Home") }
                                )
                                NavigationBarItem(
                                    selected = selectedTab == 1,
                                    onClick = { selectedTab = 1 },
                                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                                    label = { Text("Favorites") }
                                )
                            }
                        }
                    ) {
                        it.toString()
                        // Content for each tab based on selectedTab
                        when (selectedTab) {
                            0 -> PostsPage()
                            1 -> ChatRoomPage()
                            2 -> GamesPage()
                            // Add cases for other tabs
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun PostsPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(5, 27, 44))
            .padding(top = 10.dp)
    )
    {
        PostCard(content = "Post 1", img = "image")
        PostCard(content = "Post 2", img = "image")
        PostCard(content = "Post 3", img = "image")
    }

}

@Preview(showBackground = true)
@Composable
fun ChatRoomPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(5, 27, 44))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Row() {
            ItemsCard("Coding", "")
            ItemsCard("Coding", "")
            ItemsCard("Coding", "")
        }
    }
}

@Composable
fun GamesPage() {
    TODO("Not yet implemented")
}

@Composable
fun PostCard(content: String, img: String) {
    Card(modifier = Modifier.padding(10.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(87, 119, 129, 163))
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(R.drawable.btn_star_big_off), contentDescription = "")
            Text(text = content, color = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsCard(title: String, img: String) {
    val context= LocalContext.current
    Card(modifier = Modifier.padding(5.dp), onClick = { startActivity(context,Intent(context,MainActivity::class.java),null) }) {
        Column(
            Modifier
                .height(100.dp)
                .width(100.dp)
                .background(color = Color(87, 119, 129, 163)),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
//            Image(painter = painterResource(R.drawable.btn_dialog), contentDescription = "")
            Text(text = title, modifier = Modifier.padding(10.dp))
        }
    }
}

fun moveToChatRoom(context:Context)
{

}


