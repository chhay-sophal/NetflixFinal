package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.O)
var anime: MutableList<MovieModel?> = mutableListOf(
    movieList.firstOrNull { it.title == "Attack on Titan: Crimson Bow and Arrow" },
    movieList.firstOrNull { it.title == "Spirited Away" },
    movieList.firstOrNull { it.title == "Your Name" },
    movieList.firstOrNull { it.title == "Grave of the Fireflies" },
    movieList.firstOrNull { it.title == "My Neighbor Totoro" },
    movieList.firstOrNull { it.title == "Akira" },
    movieList.firstOrNull { it.title == "Princess Mononoke" },
    movieList.firstOrNull { it.title == "Ghost in the Shell" },
    movieList.firstOrNull { it.title == "Neon Genesis Evangelion: The End of Evangelion" },
    movieList.firstOrNull { it.title == "Dragon Ball Super: Broly" },
    )
