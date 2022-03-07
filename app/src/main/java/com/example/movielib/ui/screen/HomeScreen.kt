package com.example.movielib.ui.screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.R
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .background(Color.Blue)
        .fillMaxSize()
    ) {
        Column {
            GreetingSection()
        }
    }
}

@Composable
fun GreetingSection(
    name: String = "Georges"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.Center
        ) {
          Text(
              text = "Good morning, $name",
              style = MaterialTheme.typography.h2
          )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }
        Icon(painter = painterResource(id = com.example.movielib.R.drawable.ic_launcher_background),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)

        )
    }
}