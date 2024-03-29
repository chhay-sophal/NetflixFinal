package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
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
var myList: MutableList<MovieModel> = mutableStateListOf(
    MovieModel(
        title = "Dune: Part Two",
        description = "Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family. Facing a choice between love and the fate of the universe, he endeavors to prevent a terrible future only he can foresee.",
        genre = listOf(GenreModel("Sci-Fi"), GenreModel("Adventure"), GenreModel("Drama")), // Drama can be added for this movie
        year = 2024,
        duration = 166,
        image = "https://image.tmdb.org/t/p/w1280/xOMo8BRK7PfcJv9JCnx7s5hj0PX.jpg",
        cast = duneCastList
    ),
    MovieModel(
        title = "Dune",
        description = "Paul Atreides leads nomadic tribes in a battle to control the desert planet Arrakis.",
        genre = listOf(GenreModel("Science Fiction"), GenreModel("Adventure"), GenreModel("Action")),
        year = 2021,
        duration = 155,
        image = "https://image.tmdb.org/t/p/original/jYEW5xZkZk2WTrdbMGAPFuBqbDc.jpg",
        cast = duneCastList
    ),
    MovieModel(
        title = "The Lord of the Rings: The Return of the King",
        description = "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Fantasy")),
        year = 2003,
        duration = 201,
        image = "https://www.themoviedb.org/t/p/original/rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg",
        cast = duneCastList
    ),

    MovieModel(
        "Interstellar",
        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
        listOf(GenreModel("Adventure"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        2014,
        169,
        "https://www.themoviedb.org/t/p/original/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
        cast = duneCastList
    ),

    MovieModel(
        title = "Avengers: Infinity War",
        description = "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Sci-Fi")),
        year = 2018,
        duration = 149,
        image = "https://www.themoviedb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
        cast = marvelCastList
    ),

    MovieModel(
        title = "Kung Fu Panda",
        description = "When the Valley of Peace is threatened, lazy Po the panda discovers his destiny as the chosen one and trains to become a kung fu hero, but transforming the unsleek slacker into a brave warrior won't be easy.",
        genre = listOf(GenreModel("Animation"), GenreModel("Action"), GenreModel("Comedy")),
        year = 2008,
        duration = 190,
        image = "https://image.tmdb.org/t/p/original/tPNVanfI18Pbjn4jqElWqLPBJ4z.jpg",
        cast = marvelCastList
    ),
    MovieModel(
        "Interstellar",
        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
        listOf(GenreModel("Adventure"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        2014,
        169,
        "https://www.themoviedb.org/t/p/original/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
        cast = duneCastList
    ),
)
