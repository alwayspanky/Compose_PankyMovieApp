package com.example.pankymovieapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pankymovieapp.model.getMovies
import com.example.pankymovieapp.widget.MovieCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String?
){
    val newMovieList = getMovies().filter {movie->
        movie.id == movieId
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Movie Details")
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Gray),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                })

        }
    ) {paddingValues->
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = paddingValues.calculateTopPadding())
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                MovieCard(movie = newMovieList[0])
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
               Text(text = "Movie Images")
                    LazyRow(){
                        items(newMovieList[0].images){image->
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .height(200.dp)
                            ) {
                                AsyncImage(model = image, contentDescription = "movie image")
                            }
                        }

                    }


            }
        }

    }

}