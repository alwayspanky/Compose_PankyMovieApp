package com.example.pankymovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pankymovieapp.navigation.MovieNavigation
import com.example.pankymovieapp.ui.theme.PankyMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable ()-> Unit){
    PankyMovieAppTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
      MyApp {
         MovieNavigation()
      }

}