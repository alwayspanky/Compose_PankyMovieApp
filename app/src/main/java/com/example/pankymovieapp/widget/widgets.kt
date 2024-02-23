package com.example.pankymovieapp.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.pankymovieapp.model.Movie
import com.example.pankymovieapp.model.getMovies

@Preview
@Composable
fun MovieCard(
    movie: Movie = getMovies()[0],
    onItemClick: (String)-> Unit ={}
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth()
        .clickable {
            onItemClick(movie.id)

        },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(80.dp)
                    .padding(10.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.images[0])
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "movie icon")
//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie image")
            }

            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = movie.title, style = TextStyle(fontWeight = FontWeight.Bold))
                Text(text = "Director : ${movie.director}")
                Text(text = "Year : ${movie.year}")

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp
                                )
                            ) {
                                append("Plot: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(movie.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(3.dp))
                        Text(
                            text = "Actors : ${movie.actors}",
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = "Rating : ${movie.rating}",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }



                Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowUp
                                    else Icons.Filled.KeyboardArrowDown ,
                    contentDescription = "arrow down",
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    })

            }

        }

    }
}