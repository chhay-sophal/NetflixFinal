package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
val moreLikeThis: MutableList<MovieModel?> = mutableListOf(
    movieList.firstOrNull { it.title == "Avatar" },
    movieList.firstOrNull { it.title == "Blade Runner 2049" },
    movieList.firstOrNull { it.title == "Damsel" },
    movieList.firstOrNull { it.title == "The Queen's Gambit" },
    movieList.firstOrNull { it.title == "Barbie" },
    movieList.firstOrNull { it.title == "The Falcon and the Winter Soldier" }
)
