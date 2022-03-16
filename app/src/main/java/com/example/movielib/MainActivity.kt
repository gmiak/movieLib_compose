package com.example.movielib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.movielib.view.screen.HomeScreen
import com.example.movielib.view.theme.MovieLibTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieLibTheme {
                HomeScreen()
            }
        }
    }
}

