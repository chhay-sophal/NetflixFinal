package com.example.netflix_final.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration
import java.time.Year

data class MovieModel(val title: String, val description: String, val year: Year, val duration: Duration, val image: String)

@RequiresApi(Build.VERSION_CODES.O)
fun formatDuration(duration: Duration): String {
    val hours = duration.toHours()
    val minutes = duration.toMinutes() % 60
    return if (hours > 0) {
        "$hours hours $minutes minutes"
    } else {
        "$minutes minutes"
    }
}

@RequiresApi(Build.VERSION_CODES.O)
val movieList: MutableList<MovieModel> = mutableListOf(
    MovieModel("Spider-Man: Into the Spider-Verse", "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.", Year.of(2018), Duration.ofMinutes(117), "https://www.themoviedb.org/t/p/original/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"),
    MovieModel("The Dark Knight", "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.", Year.of(2008), Duration.ofMinutes(152), "https://cdn.europosters.eu/image/1300/art-photo/the-dark-knight-trilogy-batman-legend-i184448.jpg"),
    MovieModel("Avengers: Endgame", "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.", Year.of(2019), Duration.ofMinutes(181), "https://www.themoviedb.org/t/p/original/q6725aR8Zs4IwGMXzZT8aC8lh41.jpg"),
    MovieModel("Iron Man", "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.", Year.of(2008), Duration.ofMinutes(126), "https://www.themoviedb.org/t/p/original/78lPtwv72eTNqFW9COBYI0dWDJa.jpg"),
    MovieModel("Wonder Woman", "When a pilot crashes and tells of conflict in the outside world, Diana, an Amazonian warrior in training, leaves home to fight a war, discovering her full powers and true destiny.", Year.of(2017), Duration.ofMinutes(141), "https://hips.hearstapps.com/hmg-prod/images/wonder-woman-1984-poster-1606931235.jpg"),
    MovieModel("Black Panther", "T'Challa, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger from his country's past.", Year.of(2018), Duration.ofMinutes(134), "https://www.themoviedb.org/t/p/original/uxzzxijgPIY7slzFvMotPv8wjKA.jpg"),
    MovieModel("Captain America: The Winter Soldier", "As Steve Rogers struggles to embrace his role in the modern world, he teams up with a fellow Avenger and S.H.I.E.L.D agent, Black Widow, to battle a new threat from history: an assassin known as the Winter Soldier.", Year.of(2014), Duration.ofMinutes(136), "https://m.media-amazon.com/images/I/818xQZGm-JL.jpg"),
    MovieModel("Guardians of the Galaxy", "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.", Year.of(2014), Duration.ofMinutes(121), "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/6c658317558271.562bb863038b4.jpg"),
    MovieModel("Deadpool", "A wisecracking mercenary gets experimented on and becomes immortal but ugly, and sets out to track down the man who ruined his looks.", Year.of(2016), Duration.ofMinutes(108), "https://i.ebayimg.com/images/g/czUAAOSwo4pYmmNF/s-l1600.jpg"),
    MovieModel("The Incredibles", "A family of undercover superheroes, while trying to live the quiet suburban life, are forced into action to save the world.", Year.of(2004), Duration.ofMinutes(115), "https://i.ebayimg.com/images/g/ZOMAAOSw9N1Vi7Sd/s-l1600.jpg"),
    MovieModel("Thor: Ragnarok", "Imprisoned on the planet Sakaar, Thor must race against time to return to Asgard and stop Ragnarök, the destruction of his world, at the hands of the powerful and ruthless villain Hela.", Year.of(2017), Duration.ofMinutes(131), "https://m.media-amazon.com/images/I/A1HBBNzBdxL.jpg"),
    MovieModel("X-Men: Days of Future Past", "The X-Men send Wolverine to the past in a desperate effort to change history and prevent an event that results in doom for both humans and mutants.", Year.of(2014), Duration.ofMinutes(131), "https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p10063537_p_v8_bl.jpg"),
    MovieModel("Shazam!", "A newly fostered young boy in search of his mother instead finds unexpected super powers and soon gains a powerful enemy.", Year.of(2019), Duration.ofMinutes(132), "https://i.ebayimg.com/images/g/QcUAAOSwXj5jyI0f/s-l1600.jpg"),
    MovieModel("Doctor Strange", "While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.", Year.of(2016), Duration.ofMinutes(115), "https://m.media-amazon.com/images/I/81b6gyv977L._AC_UF894,1000_QL80_.jpg"),
    MovieModel("Ant-Man", "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.", Year.of(2015), Duration.ofMinutes(117), "https://m.media-amazon.com/images/I/81nJdLkPyiL._AC_UF894,1000_QL80_.jpg"),
    MovieModel("Aquaman", "Arthur Curry, the human-born heir to the underwater kingdom of Atlantis, goes on a quest to prevent a war between the worlds of ocean and land.", Year.of(2018), Duration.ofMinutes(143), "https://i.ebayimg.com/images/g/q7QAAOSwjg1b5ON9/s-l1600.jpg"),
    MovieModel("The Avengers", "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.", Year.of(2012), Duration.ofMinutes(143), "https://www.themoviedb.org/t/p/original/RYMX2wcKCBAr24UyPD7xwmjaTn.jpg"),
    MovieModel("Captain Marvel", "Carol Danvers becomes one of the universe's most powerful heroes when Earth is caught in the middle of a galactic war between two alien races.", Year.of(2019), Duration.ofMinutes(123), "https://www.themoviedb.org/t/p/original/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg"),
    MovieModel("Iron Man 3", "When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.", Year.of(2013), Duration.ofMinutes(130), "https://m.media-amazon.com/images/M/MV5BMjE5MzcyNjk1M15BMl5BanBnXkFtZTcwMjQ4MjcxOQ@@._V1_.jpg"),
    MovieModel("Batman Begins", "After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from corruption.", Year.of(2005), Duration.ofMinutes(140), "https://m.media-amazon.com/images/I/61-J2oc+ycL._AC_UF1000,1000_QL80_.jpg"),
    MovieModel("Man of Steel", "An alien child is evacuated from his dying world and sent to Earth to live among humans. His peace is threatened, when survivors of his home planet invade Earth.", Year.of(2013), Duration.ofMinutes(143), "https://www.themoviedb.org/t/p/original/7rIPjn5TUK04O25ZkMyHrGNPgLx.jpg")
)

//val movieList2: MutableList<MovieModel> = mutableListOf(
//    MovieModel("The Shawshank Redemption", "Redemption story", "https://images-na.ssl-images-amazon.com/images/I/51kPjGVc6NL.jpg"),
//    MovieModel("The Godfather", "Mafia drama", "https://images-na.ssl-images-amazon.com/images/I/61ajbojXyyL._AC_SY679_.jpg"),
//    MovieModel("The Dark Knight", "Dark superhero tale", "https://images-na.ssl-images-amazon.com/images/I/51dzMXzWtpL._AC_.jpg"),
//    MovieModel("The Godfather: Part II", "Mafia drama sequel", "https://images-na.ssl-images-amazon.com/images/I/51xv8%2BxTwcL._AC_SY679_.jpg"),
//    MovieModel("12 Angry Men", "Courtroom drama", "https://images-na.ssl-images-amazon.com/images/I/61F9kCHmgvL._AC_SY679_.jpg"),
//    MovieModel("Schindler's List", "Holocaust drama", "https://images-na.ssl-images-amazon.com/images/I/51U9M6eO1%2BL._AC_.jpg"),
//    MovieModel("The Lord of the Rings: The Return of the King", "Fantasy epic conclusion", "https://images-na.ssl-images-amazon.com/images/I/51K7RzJbOuL._AC_SY679_.jpg"),
//    MovieModel("Pulp Fiction", "Crime anthology", "https://images-na.ssl-images-amazon.com/images/I/51zSWyfBdHL._AC_SY679_.jpg"),
//    MovieModel("The Good, the Bad and the Ugly", "Spaghetti Western", "https://images-na.ssl-images-amazon.com/images/I/61IhNZqG%2B6L._AC_SY679_.jpg"),
//    MovieModel("The Lord of the Rings: The Fellowship of the Ring", "Fantasy epic", "https://images-na.ssl-images-amazon.com/images/I/51pWnM3-Q8L._AC_SY679_.jpg"),
//    MovieModel("Fight Club", "Psychological thriller", "https://images-na.ssl-images-amazon.com/images/I/51ttOnyk-8L._AC_.jpg"),
//    MovieModel("Forrest Gump", "Life is like a box of chocolates", "https://images-na.ssl-images-amazon.com/images/I/51A-LXnkCKL._AC_SY679_.jpg"),
//    MovieModel("Inception", "Dream within a dream", "https://images-na.ssl-images-amazon.com/images/I/41RjNLX3FoL._AC_SY679_.jpg"),
//    MovieModel("The Lord of the Rings: The Two Towers", "Fantasy epic sequel", "https://images-na.ssl-images-amazon.com/images/I/51aDKz%2BpSLL._AC_SY679_.jpg"),
//    MovieModel("Star Wars: Episode V - The Empire Strikes Back", "Galactic conflict sequel", "https://images-na.ssl-images-amazon.com/images/I/51a1sEGB4eL._AC_SY679_.jpg"),
//    MovieModel("The Matrix", "Mind-bending sci-fi", "https://images-na.ssl-images-amazon.com/images/I/61uJD3HUhuL._AC_SY679_.jpg"),
//    MovieModel("Goodfellas", "Gangster epic", "https://images-na.ssl-images-amazon.com/images/I/51z2W0fLqjL._AC_SY679_.jpg"),
//    MovieModel("One Flew Over the Cuckoo's Nest", "Psychological drama", "https://images-na.ssl-images-amazon.com/images/I/51QEVm-CF3L._AC_SY679_.jpg"),
//    MovieModel("Seven Samurai", "Epic adventure", "https://images-na.ssl-images-amazon.com/images/I/51tItc0aRiL._AC_SY679_.jpg"),
//    MovieModel("Se7en", "Psychological thriller", "https://images-na.ssl-images-amazon.com/images/I/51HVK7vN7yL._AC_SY679_.jpg")
//)

