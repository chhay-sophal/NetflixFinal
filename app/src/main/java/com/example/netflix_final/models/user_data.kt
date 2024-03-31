package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.netflix_final.R

data class UserModel(val name: String, val profile: Int)

val userList: MutableList<UserModel> = mutableListOf(
    UserModel("Sophal", R.drawable.sophal),
    UserModel("Kimheak", R.drawable.kimheak),
    UserModel("Nidate", R.drawable.nidate),
    UserModel("Sarah", R.drawable.sarah),
    UserModel("Kids", R.drawable.kids),
)

var loggedInUser: UserModel = userList[1]

@RequiresApi(Build.VERSION_CODES.O)
var myList: MutableList<MovieModel?> = mutableStateListOf(
    movieList.firstOrNull { it.title == "Dune: Part Two" },
    movieList.firstOrNull { it.title == "Blade Runner 2049" },
    movieList.firstOrNull { it.title == "The Lord of the Rings: The Return of the King" },
    movieList.firstOrNull { it.title == "Interstellar" },
    movieList.firstOrNull { it.title == "Avengers: Infinity War" },
    movieList.firstOrNull { it.title == "The Falcon and the Winter Soldier" },
)

@RequiresApi(Build.VERSION_CODES.O)
var download: MutableList<MovieModel?> = mutableStateListOf(
    movieList.firstOrNull { it.title == "Avengers: Infinity War" },
    movieList.firstOrNull { it.title == "Dune: Part Two" },
    movieList.firstOrNull { it.title == "Blade Runner 2049" },
    movieList.firstOrNull { it.title == "The Falcon and the Winter Soldier" },
)
