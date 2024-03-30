package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
var featureMovies: MutableList<MovieModel?> = mutableListOf(
    movieList.firstOrNull { it.title == "Dune" },
    movieList.firstOrNull { it.title == "Dune: Part Two" },
    movieList.firstOrNull { it.title == "Blade Runner 2049" },
    movieList.firstOrNull { it.title == "Avengers: Infinity War" },
    movieList.firstOrNull { it.title == "Interstellar" },
    movieList.firstOrNull { it.title == "Kung Fu Panda" },
    movieList.firstOrNull { it.title == "Avatar" },
)
