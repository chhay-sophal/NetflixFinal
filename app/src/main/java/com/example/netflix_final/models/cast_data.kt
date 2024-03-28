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
    CastModel("Robert Downey Jr.", "Tony Stark / Iron Man", "https://image.tmdb.org/t/p/original/im9SAqJPZKEbVZGmjXuLI4O7RvM.jpg"),
    CastModel("Chris Evans", "Steve Rogers / Captain America", "https://image.tmdb.org/t/p/w500/3bOGNsHlrswhyW79uvIHH1V43JI.jpg"),
    CastModel("Mark Ruffalo", "Bruce Banner / Hulk", "https://media.themoviedb.org/t/p/w500/5GilHMOt5PAQh6rlUKZzGmaKEI7.jpg"),
    CastModel("Chris Hemsworth", "Thor", "https://image.tmdb.org/t/p/original/tlkDiLn2G75Xr7m1ybK8QFzZBso.jpg"),
    CastModel("Scarlett Johansson", "Natasha Romanoff / Black Widow", "https://image.tmdb.org/t/p/original/6bBCPmc55gzP7TR9Th4WbykrYd0.jpg"),
    CastModel("Jeremy Renner", "Clint Barton / Hawkeye", "https://media.themoviedb.org/t/p/w500/yB84D1neTYXfWBaV0QOE9RF2VCu.jpg"),
    CastModel("Brie Larson", "Carol Danvers / Captain Marvel", "https://image.tmdb.org/t/p/original/nTABNG8Sw4EVN3xodn2JBdEmBqv.jpg")
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
