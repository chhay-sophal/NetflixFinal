package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.O)
var likeDune: MutableList<MovieModel?> = mutableListOf(
    movieList.firstOrNull { it.title == "The Godfather" },
    movieList.firstOrNull { it.title == "The Lord of the Rings: The Return of the King" },
    movieList.firstOrNull { it.title == "Avengers: Endgame" },
    movieList.firstOrNull { it.title == "Arrival" },
    movieList.firstOrNull { it.title == "Prometheus" },
    movieList.firstOrNull { it.title == "Pulp Fiction" },
    movieList.firstOrNull { it.title == "Forrest Gump" },
    movieList.firstOrNull { it.title == "The Dark Knight" },
)
