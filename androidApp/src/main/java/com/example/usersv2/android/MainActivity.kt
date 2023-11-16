package com.example.usersv2.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.usersv2.App
//import androidx.compose.ui.tooling.preview.Preview
import com.example.usersv2.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                darkTheme = isSystemInDarkTheme(),
                dynamicColor = false
            )
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

/*@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}*/
