package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.O)
var ifYouLikeMarvel: MutableList<MovieModel?> = mutableListOf(
    movieList.firstOrNull { it.title == "Spider-Man: Into the Spider-Verse" },
    movieList.firstOrNull { it.title == "Spider-Man: Across the Spider-Verse" },
    movieList.firstOrNull { it.title == "Avengers: Infinity War" },
    movieList.firstOrNull { it.title == "Avengers: Endgame" },
    movieList.firstOrNull { it.title == "The Avengers" },
)
