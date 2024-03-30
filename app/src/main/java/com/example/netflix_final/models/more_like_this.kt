package com.example.netflix_final.models

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
