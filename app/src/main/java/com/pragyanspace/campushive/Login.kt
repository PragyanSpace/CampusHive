package com.pragyanspace.campushive

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.pragyanspace.campushive.ui.theme.CampusHiveTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CampusHiveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataEntryFields(hint: String) {
    var value  by remember { mutableStateOf(TextFieldValue()) }
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(8.dp)){
        TextField(
            value = value,
            onValueChange = { value = it },
            modifier = Modifier
                .weight(1F),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color(0x417C8EB3)),
            placeholder = { Text(text = hint, color = Color.White)}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    val context=LocalContext.current
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color(5, 27, 44)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Log In", color = Color.White, fontSize = 24.sp)
            DataEntryFields(hint = "Username")
            DataEntryFields(hint = "Password")
            Button(onClick ={startActivity(context,Intent(context,LaunchActivity::class.java),null)}){
//            { Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()}) {
                Text(text = "Login")
            }
        }
    }
}