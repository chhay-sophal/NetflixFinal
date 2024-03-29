package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi

data class GenreModel(val name: String)

data class MovieModel(val title: String, val description: String, val genre: List<GenreModel>? = null,  val year: Int? = null, val duration: Int? = null, val image: String, val cast: List<CastModel>? = null)

fun formatDuration(minutes: Int): String {
    val hours = minutes / 60
    val remainingMinutes = minutes % 60

    return if (hours > 0) {
        "${hours}h ${remainingMinutes}min"
    } else {
        "${remainingMinutes}min"
    }
}

@RequiresApi(Build.VERSION_CODES.O)
var featureFilms: MutableList<MovieModel> = mutableListOf(
    MovieModel(
        title = "Dune: Part Two",
        description = "Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family. Facing a choice between love and the fate of the universe, he endeavors to prevent a terrible future only he can foresee.",
        genre = listOf(GenreModel("Sci-Fi"), GenreModel("Adventure"), GenreModel("Drama")), // Drama can be added for this movie
        year = 2024,
        duration = 166,
        image = "https://media.themoviedb.org/t/p/w500/8b8R8l88Qje9dn9OE8PY05Nxl1X.jpg",
        cast = duneCastList
    ),

    MovieModel(
        title = "Dune",
        description = "Paul Atreides leads nomadic tribes in a battle to control the desert planet Arrakis.",
        genre = listOf(GenreModel("Science Fiction"), GenreModel("Adventure"), GenreModel("Action")),
        year = 2021,
        duration = 155,
        image = "https://media.themoviedb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
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
        title = "Avatar",
        description = "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
        genre = listOf(
            GenreModel("Action"),
            GenreModel("Adventure"),
            GenreModel("Fantasy")
        ),
        year = 2009,
        duration = 162, // in minutes
        image = "https://image.tmdb.org/t/p/original/kqbnN2WodNDczBVO8O9PMGXtqYU.jpg",
        cast = listOf(
            CastModel("Sam Worthington", "Jake Sully"),
            CastModel("Zoe Saldana", "Neytiri"),
            CastModel("Sigourney Weaver", "Dr. Grace Augustine"),
            CastModel("Stephen Lang", "Colonel Miles Quaritch"),
            CastModel("Michelle Rodriguez", "Trudy Chacón")
        )
    )
)

@RequiresApi(Build.VERSION_CODES.O)
var likeDune: MutableList<MovieModel> = mutableListOf(
    MovieModel(
        title = "Blade Runner",
        description = "A blade runner must pursue and terminate four replicants who stole a ship in space, and have returned to Earth to find their creator.",
        genre = listOf(
            GenreModel("Sci-Fi"),
            GenreModel("Thriller")
        ),
        year = 1982,
        duration = 117, // in minutes
        image = "https://www.themoviedb.org/t/p/original/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg",
        cast = listOf(
            CastModel("Harrison Ford", "Rick Deckard"),
            CastModel("Rutger Hauer", "Roy Batty"),
            CastModel("Sean Young", "Rachael"),
            CastModel("Edward James Olmos", "Gaff"),
            CastModel("M. Emmet Walsh", "Captain Harry Bryant")
        )
    ),

    MovieModel(
        title = "Arrival",
        description = "A linguist is recruited by the military to assist in translating alien communications and unravel the mystery of their visitation.",
        genre = listOf(GenreModel("Drama"), GenreModel("Sci-Fi")),
        year = 2016,
        duration = (116),
        image = "https://media.themoviedb.org/t/p/w500/pEzNVQfdzYDzVK0XqxERIw2x2se.jpg"
    ),

    MovieModel(
        title = "Mad Max: Fury Road",
        description = "In a post-apocalyptic wasteland, a woman rebels against a tyrannical ruler in search of her homeland with the help of a group of female prisoners, a psychotic worshiper, and a drifter named Max.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Sci-Fi")),
        year = 2015,
        duration = (120),
        image = "https://image.tmdb.org/t/p/original/c6N4YcG5j9WKgIxY8nOhMLqluej.jpg"
    ),

    MovieModel(
        "Interstellar",
        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
        listOf(GenreModel("Adventure"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        2014,
        (169),
        "https://www.themoviedb.org/t/p/original/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
        cast = interstellarCastList
    ),

    MovieModel(
        title = "The Martian",
        description = "An astronaut becomes stranded on Mars after his team assumes him dead, and must rely on his ingenuity to find a way to signal to Earth that he is alive.",
        genre = listOf(GenreModel("Adventure"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        year = 2015,
        duration = (144),
        image = "https://image.tmdb.org/t/p/original/qAlJOHvN0lUuRCfvatUu6avUbR3.jpg"
    ),

    MovieModel(
        title = "Prometheus",
        description = "A team of scientists journey through the universe on the spaceship Prometheus on a voyage to investigate alien life forms.",
        genre = listOf(GenreModel("Adventure"), GenreModel("Mystery"), GenreModel("Sci-Fi")),
        year = 2012,
        duration = (124),
        image = "https://image.tmdb.org/t/p/original/ru0CecpagM10IaNeVLKvb2CyUor.jpg"
    ),

    MovieModel(
        title = "Inception",
        description = "A thief who enters the dreams of others to steal their secrets gets a chance to redeem himself by planting an idea in someone's mind.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Sci-Fi")),
        year = 2010,
        duration = (148),
        image = "https://image.tmdb.org/t/p/original/9egFcRMV4Z3ZdcaJAYoxmnbqZE7.jpg"
    ),

    MovieModel(
        title = "Elysium",
        description = "In the year 2154, the very wealthy live on a man-made space station while the rest of the population resides on a ruined Earth.",
        genre = listOf(GenreModel("Action"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        year = 2013,
        duration = (109),
        image = "https://image.tmdb.org/t/p/original/ib8CXYegPGQNBME03oG7i6k4IMZ.jpg"
    ),

    MovieModel(
        title = "Avatar",
        description = "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
        genre = listOf(
            GenreModel("Action"),
            GenreModel("Adventure"),
            GenreModel("Fantasy")
        ),
        year = 2009,
        duration = 162, // in minutes
        image = "https://image.tmdb.org/t/p/original/kqbnN2WodNDczBVO8O9PMGXtqYU.jpg",
        cast = listOf(
            CastModel("Sam Worthington", "Jake Sully"),
            CastModel("Zoe Saldana", "Neytiri"),
            CastModel("Sigourney Weaver", "Dr. Grace Augustine"),
            CastModel("Stephen Lang", "Colonel Miles Quaritch"),
            CastModel("Michelle Rodriguez", "Trudy Chacón")
        )
    ),

    MovieModel(
        title = "Damsel",
        description = "It's the Wild West, circa 1870. Samuel Alabaster, an affluent pioneer, ventures across the American frontier to marry the love of his life, Penelope.",
        genre = listOf(
            GenreModel("Comedy"),
            GenreModel("Drama"),
            GenreModel("Western")
        ),
        year = 2018,
        duration = 113, // in minutes
        image = "https://media.themoviedb.org/t/p/w500/sMp34cNKjIb18UBOCoAv4DpCxwY.jpg",
        cast = listOf(
            CastModel("Robert Pattinson", "Samuel Alabaster"),
            CastModel("Mia Wasikowska", "Penelope"),
            CastModel("David Zellner", "Zachariah Running Bear"),
            CastModel("Nathan Zellner", "Parson Henry"),
            CastModel("Joseph Billingiere", "Rufus Cornell")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "The Queen's Gambit",
        description = "In a 1950s orphanage, a young girl discovers an astonishing talent for chess and begins an unlikely journey to stardom while grappling with addiction.",
        genre = listOf(
            GenreModel("Drama"),
            GenreModel("Sport")
        ),
        year = 2020,
        duration = 390, // in minutes (total duration of all episodes)
        image = "https://media.themoviedb.org/t/p/w500/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
        cast = listOf(
            CastModel("Anya Taylor-Joy", "Beth Harmon"),
            CastModel("Bill Camp", "Mr. Shaibel"),
            CastModel("Moses Ingram", "Jolene"),
            CastModel("Marielle Heller", "Alma Wheatley"),
            CastModel("Thomas Brodie-Sangster", "Benny Watts")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "Barbie",
        description = "A live-action movie adaptation based on the popular Barbie toy line. Follow Barbie on her exciting adventures in a magical world.",
        genre = listOf(
            GenreModel("Adventure"),
            GenreModel("Fantasy"),
            GenreModel("Family")
        ),
        year = 2023,
        duration = 120, // in minutes
        image = "https://media.themoviedb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg",
        cast = listOf(
            CastModel("Margot Robbie", "Barbie"),
            CastModel("Idris Elba", "Ken"),
            CastModel("Emma Stone", "Teresa"),
            CastModel("Ryan Reynolds", "Skipper"),
            CastModel("Octavia Spencer", "Nikki")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "The Falcon and the Winter Soldier",
        description = "Sam Wilson, also known as The Falcon, and Bucky Barnes, also known as The Winter Soldier, team up on a global adventure that tests their abilities and their patience.",
        genre = listOf(
            GenreModel("Action"),
            GenreModel("Adventure"),
            GenreModel("Drama")
        ),
        year = 2021,
        duration = 360, // in minutes (total duration of all episodes)
        image = "https://media.themoviedb.org/t/p/w220_and_h330_face/zA8ld5GRfLAjw1ow8Fm4IDyWYvi.jpg",
        cast = listOf(
            CastModel("Anthony Mackie", "Sam Wilson / Falcon"),
            CastModel("Sebastian Stan", "Bucky Barnes / Winter Soldier"),
            CastModel("Wyatt Russell", "John Walker / U.S. Agent"),
            CastModel("Emily VanCamp", "Sharon Carter / Agent 13"),
            CastModel("Daniel Brühl", "Helmut Zemo")
            // Add more cast members as needed
        )
    )
)

@RequiresApi(Build.VERSION_CODES.O)
val movieList: MutableList<MovieModel> = mutableListOf(
    MovieModel(
        title = "Avatar",
        description = "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
        genre = listOf(
            GenreModel("Action"),
            GenreModel("Adventure"),
            GenreModel("Fantasy")
        ),
        year = 2009,
        duration = 162, // in minutes
        image = "https://image.tmdb.org/t/p/original/kqbnN2WodNDczBVO8O9PMGXtqYU.jpg",
        cast = listOf(
            CastModel("Sam Worthington", "Jake Sully"),
            CastModel("Zoe Saldana", "Neytiri"),
            CastModel("Sigourney Weaver", "Dr. Grace Augustine"),
            CastModel("Stephen Lang", "Colonel Miles Quaritch"),
            CastModel("Michelle Rodriguez", "Trudy Chacón")
        )
    ),

    MovieModel(
        title = "Damsel",
        description = "It's the Wild West, circa 1870. Samuel Alabaster, an affluent pioneer, ventures across the American frontier to marry the love of his life, Penelope.",
        genre = listOf(
            GenreModel("Comedy"),
            GenreModel("Drama"),
            GenreModel("Western")
        ),
        year = 2018,
        duration = 113, // in minutes
        image = "https://media.themoviedb.org/t/p/w500/sMp34cNKjIb18UBOCoAv4DpCxwY.jpg",
        cast = listOf(
            CastModel("Robert Pattinson", "Samuel Alabaster"),
            CastModel("Mia Wasikowska", "Penelope"),
            CastModel("David Zellner", "Zachariah Running Bear"),
            CastModel("Nathan Zellner", "Parson Henry"),
            CastModel("Joseph Billingiere", "Rufus Cornell")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "The Queen's Gambit",
        description = "In a 1950s orphanage, a young girl discovers an astonishing talent for chess and begins an unlikely journey to stardom while grappling with addiction.",
        genre = listOf(
            GenreModel("Drama"),
            GenreModel("Sport")
        ),
        year = 2020,
        duration = 390, // in minutes (total duration of all episodes)
        image = "https://media.themoviedb.org/t/p/w500/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
        cast = listOf(
            CastModel("Anya Taylor-Joy", "Beth Harmon"),
            CastModel("Bill Camp", "Mr. Shaibel"),
            CastModel("Moses Ingram", "Jolene"),
            CastModel("Marielle Heller", "Alma Wheatley"),
            CastModel("Thomas Brodie-Sangster", "Benny Watts")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "Barbie",
        description = "A live-action movie adaptation based on the popular Barbie toy line. Follow Barbie on her exciting adventures in a magical world.",
        genre = listOf(
            GenreModel("Adventure"),
            GenreModel("Fantasy"),
            GenreModel("Family")
        ),
        year = 2023,
        duration = 120, // in minutes
        image = "https://media.themoviedb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg",
        cast = listOf(
            CastModel("Margot Robbie", "Barbie"),
            CastModel("Idris Elba", "Ken"),
            CastModel("Emma Stone", "Teresa"),
            CastModel("Ryan Reynolds", "Skipper"),
            CastModel("Octavia Spencer", "Nikki")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "The Falcon and the Winter Soldier",
        description = "Sam Wilson, also known as The Falcon, and Bucky Barnes, also known as The Winter Soldier, team up on a global adventure that tests their abilities and their patience.",
        genre = listOf(
            GenreModel("Action"),
            GenreModel("Adventure"),
            GenreModel("Drama")
        ),
        year = 2021,
        duration = 360, // in minutes (total duration of all episodes)
        image = "https://media.themoviedb.org/t/p/w220_and_h330_face/zA8ld5GRfLAjw1ow8Fm4IDyWYvi.jpg",
        cast = listOf(
            CastModel("Anthony Mackie", "Sam Wilson / Falcon"),
            CastModel("Sebastian Stan", "Bucky Barnes / Winter Soldier"),
            CastModel("Wyatt Russell", "John Walker / U.S. Agent"),
            CastModel("Emily VanCamp", "Sharon Carter / Agent 13"),
            CastModel("Daniel Brühl", "Helmut Zemo")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "Blade Runner",
        description = "A blade runner must pursue and terminate four replicants who stole a ship in space, and have returned to Earth to find their creator.",
        genre = listOf(
            GenreModel("Sci-Fi"),
            GenreModel("Thriller")
        ),
        year = 1982,
        duration = 117, // in minutes
        image = "https://www.themoviedb.org/t/p/original/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg",
        cast = listOf(
            CastModel("Harrison Ford", "Rick Deckard"),
            CastModel("Rutger Hauer", "Roy Batty"),
            CastModel("Sean Young", "Rachael"),
            CastModel("Edward James Olmos", "Gaff"),
            CastModel("M. Emmet Walsh", "Captain Harry Bryant")
        )
    ),
    MovieModel(
        title = "Dune",
        description = "Paul Atreides leads nomadic tribes in a battle to control the desert planet Arrakis.",
        genre = listOf(GenreModel("Science Fiction"), GenreModel("Adventure"), GenreModel("Action")),
        year = 2021,
        duration = (155),
        image = "https://media.themoviedb.org/t/p/w500/d5NXSklXo0qyIYkgV94XAgMIckC.jpg",
        cast = duneCastList
    ),
    MovieModel(
        title = "Dune: Part Two",
        description = "Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family. Facing a choice between love and the fate of the universe, he endeavors to prevent a terrible future only he can foresee.",
        genre = listOf(GenreModel("Sci-Fi"), GenreModel("Adventure"), GenreModel("Drama")), // Drama can be added for this movie
        year = 2024,
        duration = (166),
        image = "https://media.themoviedb.org/t/p/w500/8b8R8l88Qje9dn9OE8PY05Nxl1X.jpg",
        cast = duneCastList
    ),
    MovieModel(
        title = "No Time to Die",
        description = "James Bond has left active service. His peace is short-lived when Felix Leiter, an old friend from the CIA, turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Thriller")),
        year = 2021,
        duration = (163),
        image = "https://image.tmdb.org/t/p/original/aGqbo87fnIKRe1i2QgpCQCMbhfk.jpg"
    ),
    MovieModel(
        title = "Joker",
        description = "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
        genre = listOf(GenreModel("Crime"), GenreModel("Drama"), GenreModel("Thriller")),
        year = 2019,
        duration = (122),
        image = "https://www.themoviedb.org/t/p/original/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg"
    ),
    MovieModel(
        title = "Parasite",
        description = "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
        genre = listOf(GenreModel("Drama"), GenreModel("Thriller"), GenreModel("Comedy")),
        year = 2019,
        duration = (132),
        image = "https://www.themoviedb.org/t/p/original/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg"
    ),
    MovieModel(
        title = "The Shawshank Redemption",
        description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
        genre = listOf(GenreModel("Drama"), GenreModel("Crime")),
        year = 1994,
        duration = (142),
        image = "https://www.themoviedb.org/t/p/original/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg"
    ),
    MovieModel(
        "Spider-Man: Into the Spider-Verse",
        "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.",
        listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Animation")), // List of genres for Spider-Man
        2018,
        (117),
        "https://www.themoviedb.org/t/p/original/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"
    ),
    MovieModel(
        "The Dark Knight",
        "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
        listOf(GenreModel("Action"), GenreModel("Crime"), GenreModel("Drama")),
        2008,
        (152),
        "https://cdn.europosters.eu/image/1300/art-photo/the-dark-knight-trilogy-batman-legend-i184448.jpg"
    ),
    MovieModel(
        "Inception",
        "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
        listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Sci-Fi")),
        2010,
        (148),
        "https://www.themoviedb.org/t/p/original/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg"
    ),
    MovieModel(
        "The Matrix",
        "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
        listOf(GenreModel("Action"), GenreModel("Sci-Fi")),
        1999,
        (136),
        "https://image.tmdb.org/t/p/original/A9OXCnHSpcajS04Z3nPYcXE1mB8.jpg"
    ),
    MovieModel(
        "The Lord of the Rings: The Fellowship of the Ring",
        "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
        listOf(GenreModel("Adventure"), GenreModel("Drama"), GenreModel("Fantasy")),
        2001,
        (178),
        "https://image.tmdb.org/t/p/w500/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg"
    ),
    MovieModel(
        "The Shawshank Redemption",
        "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
        listOf(GenreModel("Drama")),
        1994,
        (142),
        "https://media.themoviedb.org/t/p/w500/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"
    ),
    MovieModel(
        "Forrest Gump",
        "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.",
        listOf(GenreModel("Drama"), GenreModel("Romance")),
        1994,
        (142),
        "https://image.tmdb.org/t/p/original/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg"
    ),
    MovieModel(
        "Interstellar",
        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
        listOf(GenreModel("Adventure"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        2014,
        (169),
        "https://www.themoviedb.org/t/p/original/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
        cast = interstellarCastList
    ),
    MovieModel(
        "The Silence of the Lambs",
        "A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.",
        listOf(GenreModel("Crime"), GenreModel("Drama"), GenreModel("Thriller")),
        1991,
        (118),
        "https://media.themoviedb.org/t/p/w500/uS9m8OBk1A8eM9I042bx8XXpqAq.jpg"
    ),
    MovieModel(
        "Gladiator",
        "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.",
        listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Drama")),
        2000,
        (155),
        "https://image.tmdb.org/t/p/original/ofDw0himYNpehWA69OkPWOzXOYK.jpg"
    ),
    MovieModel(
        "Pulp Fiction",
        "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
        listOf(GenreModel("Crime"), GenreModel("Drama")),
        1994,
        (154),
        "https://image.tmdb.org/t/p/original/azhKGbpACcqRsCd7uwaVWJSVQQ3.jpg"
    ),
    MovieModel(
        "The Godfather",
        "An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.",
        listOf(GenreModel("Crime"), GenreModel("Drama")),
        1972,
        (175),
        "https://image.tmdb.org/t/p/original/zOYiXN7VKhMlvUxt6Zul5IwmYWs.jpg"
    ),
    MovieModel(
        title = "The Lord of the Rings: The Return of the King",
        description = "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Fantasy")),
        year = 2003,
        duration = (201),
        image = "https://www.themoviedb.org/t/p/original/rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg"
    ),
    MovieModel(
        title = "Avengers: Infinity War",
        description = "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Sci-Fi")),
        year = 2018,
        duration = (149),
        image = "https://www.themoviedb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
        cast = marvelCastList
    ),
    MovieModel(
        title = "Kung Fu Panda",
        description = "When the Valley of Peace is threatened, lazy Po the panda discovers his destiny as the chosen one and trains to become a kung fu hero, but transforming the unsleek slacker into a brave warrior won't be easy.",
        genre = listOf(GenreModel("Animation"), GenreModel("Action"), GenreModel("Comedy")),
        year = 2008,
        duration = (90),
        image = "https://image.tmdb.org/t/p/original/tPNVanfI18Pbjn4jqElWqLPBJ4z.jpg"
    ),
    MovieModel(
        title = "Kung Fu Panda",
        description = "When the Valley of Peace is threatened, lazy Po the panda discovers his destiny as the chosen one and trains to become a kung fu hero, but transforming the unsleek slacker into a brave warrior won't be easy.",
        genre = listOf(GenreModel("Animation"), GenreModel("Action"), GenreModel("Comedy")),
        year = 2008,
        duration = (90),
        image = "https://image.tmdb.org/t/p/original/tPNVanfI18Pbjn4jqElWqLPBJ4z.jpg"
    ),
    MovieModel(
        title = "Arrival",
        description = "A linguist is recruited by the military to assist in translating alien communications and unravel the mystery of their visitation.",
        genre = listOf(GenreModel("Drama"), GenreModel("Sci-Fi")),
        year = 2016,
        duration = (116),
        image = "https://media.themoviedb.org/t/p/w500/pEzNVQfdzYDzVK0XqxERIw2x2se.jpg"
    ),
    MovieModel(
        title = "Mad Max: Fury Road",
        description = "In a post-apocalyptic wasteland, a woman rebels against a tyrannical ruler in search of her homeland with the help of a group of female prisoners, a psychotic worshiper, and a drifter named Max.",
        genre = listOf(GenreModel("Action"), GenreModel("Adventure"), GenreModel("Sci-Fi")),
        year = 2015,
        duration = (120),
        image = "https://image.tmdb.org/t/p/original/c6N4YcG5j9WKgIxY8nOhMLqluej.jpg"
    ),
    MovieModel(
        title = "The Martian",
        description = "An astronaut becomes stranded on Mars after his team assumes him dead, and must rely on his ingenuity to find a way to signal to Earth that he is alive.",
        genre = listOf(GenreModel("Adventure"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        year = 2015,
        duration = (144),
        image = "https://image.tmdb.org/t/p/original/qAlJOHvN0lUuRCfvatUu6avUbR3.jpg"
    ),
    MovieModel(
        title = "Prometheus",
        description = "A team of scientists journey through the universe on the spaceship Prometheus on a voyage to investigate alien life forms.",
        genre = listOf(GenreModel("Adventure"), GenreModel("Mystery"), GenreModel("Sci-Fi")),
        year = 2012,
        duration = (124),
        image = "https://image.tmdb.org/t/p/original/ru0CecpagM10IaNeVLKvb2CyUor.jpg"
    ),
    MovieModel(
        title = "Elysium",
        description = "In the year 2154, the very wealthy live on a man-made space station while the rest of the population resides on a ruined Earth.",
        genre = listOf(GenreModel("Action"), GenreModel("Drama"), GenreModel("Sci-Fi")),
        year = 2013,
        duration = (109),
        image = "https://image.tmdb.org/t/p/original/ib8CXYegPGQNBME03oG7i6k4IMZ.jpg"
    ),
)

@RequiresApi(Build.VERSION_CODES.O)
val moreLikeThis: MutableList<MovieModel> = mutableListOf(
    MovieModel(
        title = "Avatar",
        description = "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
        genre = listOf(
            GenreModel("Action"),
            GenreModel("Adventure"),
            GenreModel("Fantasy")
        ),
        year = 2009,
        duration = 162, // in minutes
        image = "https://image.tmdb.org/t/p/original/kqbnN2WodNDczBVO8O9PMGXtqYU.jpg",
        cast = listOf(
            CastModel("Sam Worthington", "Jake Sully"),
            CastModel("Zoe Saldana", "Neytiri"),
            CastModel("Sigourney Weaver", "Dr. Grace Augustine"),
            CastModel("Stephen Lang", "Colonel Miles Quaritch"),
            CastModel("Michelle Rodriguez", "Trudy Chacón")
        )
    ),
    MovieModel(
        title = "Blade Runner",
        description = "A blade runner must pursue and terminate four replicants who stole a ship in space, and have returned to Earth to find their creator.",
        genre = listOf(
            GenreModel("Sci-Fi"),
            GenreModel("Thriller")
        ),
        year = 1982,
        duration = 117, // in minutes
        image = "https://www.themoviedb.org/t/p/original/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg",
        cast = listOf(
            CastModel("Harrison Ford", "Rick Deckard"),
            CastModel("Rutger Hauer", "Roy Batty"),
            CastModel("Sean Young", "Rachael"),
            CastModel("Edward James Olmos", "Gaff"),
            CastModel("M. Emmet Walsh", "Captain Harry Bryant")
        )
    ),
    MovieModel(
        title = "Damsel",
        description = "It's the Wild West, circa 1870. Samuel Alabaster, an affluent pioneer, ventures across the American frontier to marry the love of his life, Penelope.",
        genre = listOf(
            GenreModel("Comedy"),
            GenreModel("Drama"),
            GenreModel("Western")
        ),
        year = 2018,
        duration = 113, // in minutes
        image = "https://media.themoviedb.org/t/p/w500/sMp34cNKjIb18UBOCoAv4DpCxwY.jpg",
        cast = listOf(
            CastModel("Robert Pattinson", "Samuel Alabaster"),
            CastModel("Mia Wasikowska", "Penelope"),
            CastModel("David Zellner", "Zachariah Running Bear"),
            CastModel("Nathan Zellner", "Parson Henry"),
            CastModel("Joseph Billingiere", "Rufus Cornell")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "The Queen's Gambit",
        description = "In a 1950s orphanage, a young girl discovers an astonishing talent for chess and begins an unlikely journey to stardom while grappling with addiction.",
        genre = listOf(
            GenreModel("Drama"),
            GenreModel("Sport")
        ),
        year = 2020,
        duration = 390, // in minutes (total duration of all episodes)
        image = "https://media.themoviedb.org/t/p/w500/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
        cast = listOf(
            CastModel("Anya Taylor-Joy", "Beth Harmon"),
            CastModel("Bill Camp", "Mr. Shaibel"),
            CastModel("Moses Ingram", "Jolene"),
            CastModel("Marielle Heller", "Alma Wheatley"),
            CastModel("Thomas Brodie-Sangster", "Benny Watts")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "Barbie",
        description = "A live-action movie adaptation based on the popular Barbie toy line. Follow Barbie on her exciting adventures in a magical world.",
        genre = listOf(
            GenreModel("Adventure"),
            GenreModel("Fantasy"),
            GenreModel("Family")
        ),
        year = 2023,
        duration = 120, // in minutes
        image = "https://media.themoviedb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg",
        cast = listOf(
            CastModel("Margot Robbie", "Barbie"),
            CastModel("Idris Elba", "Ken"),
            CastModel("Emma Stone", "Teresa"),
            CastModel("Ryan Reynolds", "Skipper"),
            CastModel("Octavia Spencer", "Nikki")
            // Add more cast members as needed
        )
    ),
    MovieModel(
        title = "The Falcon and the Winter Soldier",
        description = "Sam Wilson, also known as The Falcon, and Bucky Barnes, also known as The Winter Soldier, team up on a global adventure that tests their abilities and their patience.",
        genre = listOf(
            GenreModel("Action"),
            GenreModel("Adventure"),
            GenreModel("Drama")
        ),
        year = 2021,
        duration = 360, // in minutes (total duration of all episodes)
        image = "https://media.themoviedb.org/t/p/w220_and_h330_face/zA8ld5GRfLAjw1ow8Fm4IDyWYvi.jpg",
        cast = listOf(
            CastModel("Anthony Mackie", "Sam Wilson / Falcon"),
            CastModel("Sebastian Stan", "Bucky Barnes / Winter Soldier"),
            CastModel("Wyatt Russell", "John Walker / U.S. Agent"),
            CastModel("Emily VanCamp", "Sharon Carter / Agent 13"),
            CastModel("Daniel Brühl", "Helmut Zemo")
            // Add more cast members as needed
        )
    )
)

@RequiresApi(Build.VERSION_CODES.O)
var continueWatching: List<MovieModel> = movieList.take(8)
