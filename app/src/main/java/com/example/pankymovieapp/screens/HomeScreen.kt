package com.example.pankymovieapp.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.pankymovieapp.model.Movie
import com.example.pankymovieapp.model.getMovies
import com.example.pankymovieapp.navigation.MovieScreens
import com.example.pankymovieapp.widget.MovieCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Movies")
            },colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Gray))
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            MainContent(navController = navController)
        }

    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
){
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            LazyColumn{
                items(items = movieList){
                    MovieCard(movie = it){ name->
                        Log.d("TAG", "Movie Name: $name")
                        navController.navigate(MovieScreens.DetailsScreen.name+"/$name")
                    }
                }
            }
        }
    }
}

