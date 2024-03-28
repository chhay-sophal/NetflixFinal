package com.example.netflix_final.models

import android.media.Image

data class CastModel(
    val actorName: String,
    val characterName: String,
    val imageUrl: String? = null
)

val duneCastList = listOf(
    CastModel("Timothée Chalamet", "Paul Atreides", "https://media.themoviedb.org/t/p/w500/BE2sdjpgsa2rNTFa66f7upkaOP.jpg"),
    CastModel("Rebecca Ferguson", "Lady Jessica", "https://media.themoviedb.org/t/p/w500/lJloTOheuQSirSLXNA3JHsrMNfH.jpg"),
    CastModel("Oscar Isaac", "Duke Leto Atreides", "https://m.media-amazon.com/images/M/MV5BMTQ2ODE2NDQ5OF5BMl5BanBnXkFtZTcwOTU3OTM1OQ@@._V1_FMjpg_UX1000_.jpg"),
    CastModel("Josh Brolin", "Gurney Halleck", "https://media.themoviedb.org/t/p/w500/sX2etBbIkxRaCsATyw5ZpOVMPTD.jpg"),
    CastModel("Stellan Skarsgård", "Baron Vladimir Harkonnen", "https://media.themoviedb.org/t/p/w500/x78BtYHElirO7Iw8bL4m8CnzRDc.jpg"),
    CastModel("Dave Bautista", "Glossu Rabban", "https://image.tmdb.org/t/p/original/fB8C7M6Am956NQW10ltqX3kXo2W.jpg"),
    CastModel("Zendaya", "Chani", "https://image.tmdb.org/t/p/original/3WdOloHpjtjL96uVOhFRRCcYSwq.jpg")
)

val marvelCastList = listOf(
    // Assuming the movie is "Avengers: Endgame"
    CastModel("Robert Downey Jr.", "Tony Stark / Iron Man"),
    CastModel("Chris Evans", "Steve Rogers / Captain America"),
    CastModel("Mark Ruffalo", "Bruce Banner / Hulk"),
    CastModel("Chris Hemsworth", "Thor"),
    CastModel("Scarlett Johansson", "Natasha Romanoff / Black Widow"),
    CastModel("Jeremy Renner", "Clint Barton / Hawkeye"),
    CastModel("Brie Larson", "Carol Danvers / Captain Marvel")
)

val interstellarCastList = listOf(
    CastModel("Matthew McConaughey", "Joseph Cooper"),
    CastModel("Anne Hathaway", "Dr. Amelia Brand"),
    CastModel("Jessica Chastain", "Murph (adult)"),
    CastModel("Mackenzie Foy", "Murph (10 years old)"),
    CastModel("Ellen Burstyn", "Murph (elderly)"),
    CastModel("Michael Caine", "Professor Brand"),
    CastModel("Casey Affleck", "Tom"),
    CastModel("Timothée Chalamet", "Young Tom"),
    CastModel("John Lithgow", "Donald"),
    CastModel("David Gyasi", "Romilly"),
    CastModel("Wes Bentley", "Doyle"),
    CastModel("Bill Irwin", "TARS (voice)"),
    CastModel("Josh Stewart", "CASE (voice)")
)
