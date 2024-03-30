package com.example.netflix_final.models

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

val dunePartTwoCastList = listOf(
    CastModel("Timothée Chalamet", "Paul Atreides", "https://media.themoviedb.org/t/p/w500/BE2sdjpgsa2rNTFa66f7upkaOP.jpg"),
    CastModel("Rebecca Ferguson", "Lady Jessica", "https://media.themoviedb.org/t/p/w500/lJloTOheuQSirSLXNA3JHsrMNfH.jpg"),
    CastModel("Zendaya", "Chani", "https://image.tmdb.org/t/p/original/3WdOloHpjtjL96uVOhFRRCcYSwq.jpg"),
    CastModel("Josh Brolin", "Gurney Halleck", "https://media.themoviedb.org/t/p/w500/sX2etBbIkxRaCsATyw5ZpOVMPTD.jpg"),
    CastModel("Javier Bardem", "Stilgar", "https://media.themoviedb.org/t/p/w500/IShnFg6ijWhpbu29dFBd9PtqQg.jpg"),
    CastModel("Stellan Skarsgård", "Baron Vladimir Harkonnen", "https://media.themoviedb.org/t/p/w500/x78BtYHElirO7Iw8bL4m8CnzRDc.jpg"),
    CastModel("Dave Bautista", "Glossu Rabban", "https://image.tmdb.org/t/p/original/fB8C7M6Am956NQW10ltqX3kXo2W.jpg"),
    CastModel("Austin Butler", "Feyd-Rautha Harkonnen", "https://media.themoviedb.org/t/p/w500/jn63A9goIetyvJt5DTHypjk33ip.jpg"),
    CastModel("Florence Pugh", "Princess Irulan", "https://media.themoviedb.org/t/p/w500/f8e41Oon18FiEZr4zgyJDVUqOeh.jpg"),
    CastModel("Christopher Walken", "Emperor Shaddam IV", "https://media.themoviedb.org/t/p/w500/ApgDL7nudR9T2GpjCG4vESgymO2.jpg"),
    CastModel("Léa Seydoux", "Lady Margot Fenring", "https://media.themoviedb.org/t/p/w500/tUfoM95x70Qsb1ElClPSpSrZQ2v.jpg")
)

val avengersEndgameCastList = listOf(
    CastModel("Robert Downey Jr.", "Tony Stark / Iron Man", "https://image.tmdb.org/t/p/original/im9SAqJPZKEbVZGmjXuLI4O7RvM.jpg"),
    CastModel("Chris Evans", "Steve Rogers / Captain America", "https://image.tmdb.org/t/p/w500/3bOGNsHlrswhyW79uvIHH1V43JI.jpg"),
    CastModel("Mark Ruffalo", "Bruce Banner / Hulk", "https://media.themoviedb.org/t/p/w500/5GilHMOt5PAQh6rlUKZzGmaKEI7.jpg"),
    CastModel("Chris Hemsworth", "Thor", "https://image.tmdb.org/t/p/original/tlkDiLn2G75Xr7m1ybK8QFzZBso.jpg"),
    CastModel("Scarlett Johansson", "Natasha Romanoff / Black Widow", "https://image.tmdb.org/t/p/original/6bBCPmc55gzP7TR9Th4WbykrYd0.jpg"),
    CastModel("Jeremy Renner", "Clint Barton / Hawkeye", "https://media.themoviedb.org/t/p/w500/yB84D1neTYXfWBaV0QOE9RF2VCu.jpg"),
    CastModel("Don Cheadle", "James Rhodes / War Machine", "image"),
    CastModel("Paul Rudd", "Scott Lang / Ant-Man", "image"),
    CastModel("Brie Larson", "Carol Danvers / Captain Marvel", "https://image.tmdb.org/t/p/original/nTABNG8Sw4EVN3xodn2JBdEmBqv.jpg"),
    CastModel("Chris Pratt", "Peter Quill / Star-Lord", "image"),
    CastModel("Zoe Saldana", "Gamora", "image"),
    CastModel("Dave Bautista", "Drax", "image"),
    CastModel("Bradley Cooper", "Rocket (voice)"),
    CastModel("Vin Diesel", "Groot (voice)"),
    CastModel("Karen Gillan", "Nebula", "image"),
    CastModel("Josh Brolin", "Thanos", "image"),
    CastModel("Tom Holland", "Peter Parker / Spider-Man", "image"),
    CastModel("Sebastian Stan", "James Buchanan Barnes / Winter Soldier", "image"),
    CastModel("Anthony Mackie", "Sam Wilson / Falcon", "image"),
    CastModel("Elizabeth Olsen", "Wanda Maximoff / Scarlet Witch", "image"),
    CastModel("Paul Bettany", "Vision", "image"),
    CastModel("Benedict Cumberbatch", "Stephen Strange / Doctor Strange", "image"),
    // Include other cast members as desired
)

val infinityWarCastList = listOf(
    CastModel("Robert Downey Jr.", "Tony Stark / Iron Man", "https://image.tmdb.org/t/p/original/im9SAqJPZKEbVZGmjXuLI4O7RvM.jpg"),
    CastModel("Chris Evans", "Steve Rogers / Captain America", "https://image.tmdb.org/t/p/w500/3bOGNsHlrswhyW79uvIHH1V43JI.jpg"),
    CastModel("Mark Ruffalo", "Bruce Banner / Hulk", "https://media.themoviedb.org/t/p/w500/5GilHMOt5PAQh6rlUKZzGmaKEI7.jpg"),
    CastModel("Chris Hemsworth", "Thor", "https://image.tmdb.org/t/p/original/tlkDiLn2G75Xr7m1ybK8QFzZBso.jpg"),
    CastModel("Scarlett Johansson", "Natasha Romanoff / Black Widow", "https://image.tmdb.org/t/p/original/6bBCPmc55gzP7TR9Th4WbykrYd0.jpg"),
    CastModel("Benedict Cumberbatch", "Stephen Strange / Doctor Strange", "image"),
    CastModel("Don Cheadle", "James Rhodes / War Machine", "image"),
    CastModel("Tom Holland", "Peter Parker / Spider-Man", "image"),
    CastModel("Chadwick Boseman", "T'Challa / Black Panther", "image"),
    CastModel("Paul Bettany", "Vision", "image"),
    CastModel("Elizabeth Olsen", "Wanda Maximoff / Scarlet Witch", "image"),
    CastModel("Anthony Mackie", "Sam Wilson / Falcon", "image"),
    CastModel("Sebastian Stan", "James Buchanan Barnes / Winter Soldier", "image"),
    CastModel("Danai Gurira", "Okoye", "image"),
    CastModel("Letitia Wright", "Shuri", "image"),
    CastModel("Dave Bautista", "Drax", "image"),
    CastModel("Zoe Saldana", "Gamora", "image"),
    CastModel("Josh Brolin", "Thanos", "image"),
    CastModel("Chris Pratt", "Peter Quill / Star-Lord", "image"),
    CastModel("Bradley Cooper", "Rocket (voice)", "image"),
    CastModel("Vin Diesel", "Groot (voice)", "image"),
    CastModel("Karen Gillan", "Nebula", "image"),
    CastModel("Pom Klementieff", "Mantis", "image"),
    CastModel("Tom Vaughan-Lawlor", "Ebony Maw", "image"),
    CastModel("Terry Notary", "Cull Obsidian", "image"),
    CastModel("Michael James Shaw", "Corvus Glaive", "image"),
    CastModel("Winston Duke", "M'Baku", "image"),
    CastModel("Benedict Wong", "Wong", "image"),
    CastModel("Gwyneth Paltrow", "Pepper Potts", "image"),
    CastModel("Jacob Batalon", "Ned Leeds", "image"),
    CastModel("Zendaya", "MJ", "image"),
    CastModel("Jon Favreau", "Happy Hogan", "image"),
    CastModel("Chris Pratt", "Peter Quill / Star-Lord (voice)", "image"), // Credited twice for voice acting
    CastModel("Sebastian Stan", "Bucky Barnes (voice)", "image"), // Credited twice for voice acting
    // Include other minor cast members as desired
)

val avengersCastList = listOf(
    CastModel("Robert Downey Jr.", "Tony Stark / Iron Man", "https://image.tmdb.org/t/p/original/im9SAqJPZKEbVZGmjXuLI4O7RvM.jpg"),
    CastModel("Chris Evans", "Steve Rogers / Captain America", "https://image.tmdb.org/t/p/w500/3bOGNsHlrswhyW79uvIHH1V43JI.jpg"),
    CastModel("Mark Ruffalo", "Bruce Banner / Hulk", "https://media.themoviedb.org/t/p/w500/5GilHMOt5PAQh6rlUKZzGmaKEI7.jpg"),
    CastModel("Chris Hemsworth", "Thor", "https://image.tmdb.org/t/p/original/tlkDiLn2G75Xr7m1ybK8QFzZBso.jpg"),
    CastModel("Scarlett Johansson", "Natasha Romanoff / Black Widow", "https://image.tmdb.org/t/p/original/6bBCPmc55gzP7TR9Th4WbykrYd0.jpg"),
    CastModel("Jeremy Renner", "Clint Barton / Hawkeye", "https://media.themoviedb.org/t/p/w500/yB84D1neTYXfWBaV0QOE9RF2VCu.jpg"),
    CastModel("Tom Hiddleston", "Loki", "https://media.themoviedb.org/t/p/w500/mclHxMm8aPlCPKptP67257F5GPo.jpg"),
    CastModel("Samuel L. Jackson", "Nick Fury", "https://image.tmdb.org/t/p/original/jv4zXZmZZonC3ub6f2SSLGI048s.jpg"),
    CastModel("Clark Gregg", "Phil Coulson", "https://media.themoviedb.org/t/p/w500/nbxFbr2SaF4Sdc6HdsF193GInvJ.jpg"),
    CastModel("Cobie Smulders", "Maria Hill", "https://image.tmdb.org/t/p/original/jAz6lukhFNt8AGuyZZXiqBCZwRe.jpg"),
    CastModel("Gwyneth Paltrow", "Pepper Potts", "https://image.tmdb.org/t/p/original/6bBCPmc55gzP7TR9Th4WbykrYd0.jpg"),
    CastModel("Stellan Skarsgård", "Selvig", "https://media.themoviedb.org/t/p/w500/x78BtYHElirO7Iw8bL4m8CnzRDc.jpg"),
    // Include other cast members as desired
)

val interstellarCastList = listOf(
    CastModel("Matthew McConaughey", "Cooper", "https://media.themoviedb.org/t/p/w500/e9ZHRY5toiBZCIPEEyvOG9A8ers.jpg"),
    CastModel("Anne Hathaway", "Dr. Amelia Brand", "https://image.tmdb.org/t/p/original/rv7smEIVNl7TO9JI835dXS1Yo57.jpg"),
    CastModel("Jessica Chastain", "Murph (adult)", "https://media.themoviedb.org/t/p/w500/bXFXSlfCzoE5Py7KBP9P0Y0Ot1v.jpg"),
    CastModel("Mackenzie Foy", "Murph (10 years old)", "https://media.themoviedb.org/t/p/w500/gW9BdiA9eooBWa5bzHWkV7rbTa8.jpg"),
    CastModel("Michael Caine", "Professor Brand", "https://image.tmdb.org/t/p/original/bVZRMlpjTAO2pJK6v90buFgVbSW.jpg"),
    CastModel("Casey Affleck", "Tom", "https://image.tmdb.org/t/p/original/fGo8nikBhtI0g3InpGc3WmLZXzi.jpg"),
    CastModel("Timothée Chalamet", "Tom (15 years old)", "https://media.themoviedb.org/t/p/w500/BE2sdjpgsa2rNTFa66f7upkaOP.jpg"),
    CastModel("Bill Irwin", "TARS (voice)", "https://media.themoviedb.org/t/p/w500/bAV5qsljgiHQkn3QluB5clVYC13.jpg"),
    CastModel("Ellen Burstyn", "Old Murph", "https://media.themoviedb.org/t/p/w500/wjxo9Yw8ZoKewcRlHShfTIZGVQF.jpg")
)

val avatarCastList = listOf(
    CastModel("Sam Worthington", "Jake Sully", "image"),
    CastModel("Zoe Saldana", "Neytiri", "image"),
    CastModel("Sigourney Weaver", "Dr. Grace Augustine", "image"),
    CastModel("Stephen Lang", "Colonel Miles Quaritch", "image"),
    CastModel("Michelle Rodriguez", "Trudy Chacon", "image"),
    CastModel("Giovanni Ribisi", "Parker Selfridge", "image"),
    CastModel("Joel David Moore", "Norm Spellman", "image"),
    CastModel("CCH Pounder", "Mo'at", "image"),
    CastModel("Wes Studi", "Eytukan", "image")
)

val damselCastList = listOf(
    CastModel("Millie Bobby Brown", "Elodie", "image"),
    CastModel("Ray Winstone", "Lord Bayford", "image"),
    CastModel("Angela Bassett", "Lady Bayford", "image"),
    CastModel("Nick Robinson", "Prince Henry", "image"),
    CastModel("Robin Wright", "Queen Isabelle", "image"),
    CastModel("Brooke Carter", "Floria", "image"),
    CastModel("Milo Twomey", "King Roderick", "image"),
    CastModel("Nicole Joseph", "Princess Victoria", "image"),
)

val barbieCastList = listOf(
    CastModel("Margot Robbie", "Barbie", "image"),
    CastModel("Ryan Gosling", "Ken", "image"),
    CastModel("Issa Rae", "Barbie", "image"),
    CastModel("Kate McKinnon", "Barbie", "image"),
    CastModel("Alexandra Shipp", "Barbie", "image"),
    CastModel("Emma Mackey", "Barbie", "image"),
    CastModel("Hari Nef", "Barbie", "image"),
    CastModel("Sharon Rooney", "Barbie", "image"),
    CastModel("Ana Cruz Kayne", "Barbie", "image"),
    CastModel("Ritu Arya", "Barbie", "image"),
    CastModel("Dua Lipa", "Barbie", "image"),
    CastModel("Nicola Coughlan", "Barbie", "image"),
    CastModel("Emerald Fennell", "Midge", "image"),
    CastModel("Simu Liu", "Ken", "image"),
    CastModel("Kingsley Ben-Adir", "Ken", "image"),
    CastModel("Ncuti Gatwa", "Ken", "image"),
    CastModel("Scott Evans", "Ken", "image"),
    CastModel("John Cena", "Ken", "image"),
    CastModel("Michael Cera", "Allan", "image"),
    CastModel("Helen Mirren", "Narrator", "image"),
)

val falconAndWinterSoldierCastList = listOf(
    CastModel("Anthony Mackie", "Sam Wilson / The Falcon", "image"),
    CastModel("Sebastian Stan", "Bucky Barnes / The Winter Soldier", "image"),
    CastModel("Wyatt Russell", "John Walker / U.S. Agent", "image"),
    CastModel("Erin Kellyman", "Karli Morgenthau", "image"),
    CastModel("Danny Ramirez", "Joaquin Torres", "image"),
    CastModel("Georges St-Pierre", "Georges Batroc", "image"),
    CastModel("Adepero Oduye", "Sarah Wilson", "image"),
    CastModel("Don Cheadle", "James Rhodes / War Machine", "image"),
    CastModel("Daniel Brühl", "Helmut Zemo", "image"),
    CastModel("Emily VanCamp", "Sharon Carter / The Power Broker", "image"),
    CastModel("Julia Louis-Dreyfus", "Contessa Valentina Allegra de Fontaine", "image")
)

val bladeRunnerCastList = listOf(
    CastModel("Harrison Ford", "Rick Deckard", "image"),
    CastModel("Rutger Hauer", "Roy Batty", "image"),
    CastModel("Sean Young", "Rachael", "image"),
    CastModel("Edward James Olmos", "Gaff", "image"),
    CastModel("M. Emmet Walsh", "Bryant", "image"),
    CastModel("Daryl Hannah", "Pris Stratton", "image"),
    CastModel("William Sanderson", "J.F. Sebastian", "image"),
    CastModel("Brion James", "Leon Kowalski", "image"),
    CastModel("Joe Turkel", "Dr. Eldon Tyrell", "image"),
    CastModel("Joanna Cassidy", "Zhora Salome", "image"),
    CastModel("James Hong", "Hannibal Chew", "image"),
    CastModel("Morgan Paull", "Dave Holden", "image"),
    CastModel("Hy Pyke", "Taffey Lewis", "image"),
)

val noTimeToDieCastList = listOf(
    CastModel("Daniel Craig", "James Bond", "https://image.tmdb.org/t/p/original/6j9Hu3gZsMEl6vZHNTko9yqp0Y6.jpg"),
    CastModel("Léa Seydoux", "Dr. Madeleine Swann", "https://media.themoviedb.org/t/p/w500/tUfoM95x70Qsb1ElClPSpSrZQ2v.jpg"),
    CastModel("Rami Malek", "Lyutsifer Safin", "https://media.themoviedb.org/t/p/w500/ewr46CGOdsx5NzAJdIzEBz2yIQh.jpg"),
    CastModel("Lashana Lynch", "Nomi", "https://media.themoviedb.org/t/p/w500/ypNxRag9uJ5nzPAN2um3amQK340.jpg"),
    CastModel("Ralph Fiennes", "Gareth Mallory / M", "https://media.themoviedb.org/t/p/w500/pCnVXH1Uo2ODoOit4UXni8OD9VB.jpg"),
    CastModel("Ben Whishaw", "Q", "https://media.themoviedb.org/t/p/w500/e74Cz65ifeNb9zHfUTvF5rTix0d.jpg"),
    CastModel("Naomie Harris", "Eve Moneypenny", "https://media.themoviedb.org/t/p/w500/41TVAcYqKKF7PGf3x7QfaLvkLSW.jpg"),
    CastModel("Jeffrey Wright", "Felix Leiter", "https://media.themoviedb.org/t/p/w500/yGcuHGW4glqRpOPxgiCvjcren7F.jpg"),
    CastModel("Christoph Waltz", "Ernst Stavro Blofeld", "https://media.themoviedb.org/t/p/w500/2Hhztd4mUEV9Y25rfkXDwzL9QI9.jpg"),
)

val jokerCastList = listOf(
    CastModel("Joaquin Phoenix", "Arthur Fleck / Joker", "https://media.themoviedb.org/t/p/w500/dD7hrRueEZmQgGWBp7pAOOt5gLV.jpg"),
    CastModel("Robert De Niro", "Murray Franklin", "https://media.themoviedb.org/t/p/w500/cT8htcckIuyI1Lqwt1CvD02ynTh.jpg"),
    CastModel("Zazie Beetz", "Sophie Dumond", "https://media.themoviedb.org/t/p/w500/sgxzT54GnvgeMnOZgpQQx9csAdd.jpg"),
    CastModel("Frances Conroy", "Penny Fleck", "https://image.tmdb.org/t/p/original/8njcmiQzSxGcumMYG5aKnfeFupV.jpg"),
    CastModel("Brett Cullen", "Thomas Wayne", "https://media.themoviedb.org/t/p/w500/4P6TsRcnr9MRbXlCdHitulGM5LT.jpg"),
    CastModel("Shea Whigham", "Detectives Burke", "https://image.tmdb.org/t/p/original/suwW5Gv06Po1RzcSKVAPANrVvo3.jpg"),
    CastModel("Bill Camp", "Detectives Garrity", "https://media.themoviedb.org/t/p/w500/yZFata0EVr7TbIAz8vZFyiDKDts.jpg")
)

val parasiteCastList = listOf(
    CastModel("Song Kang-ho", "Ki-taek Kim", "https://image.tmdb.org/t/p/original/kBM9UTPYXUA2RNk210DXhztLFns.jpg"),
    CastModel("Lee Sun-kyun", "Dong-ik Park", "https://media.themoviedb.org/t/p/w500/mwF2HgyEF2UzxSvNRJEtbWlKbAj.jpg"),
    CastModel("Cho Yeo-jeong", "Yeon-kyo Park", "https://media.themoviedb.org/t/p/w500/n7YWOoquBL9g3qEwQ2zvrQSW96L.jpg"),
    CastModel("Choi Woo-sik", "Ki-woo Kim", "https://media.themoviedb.org/t/p/w500/6ORYWOw0BZuTwZptins0fJO6bKL.jpg"),
    CastModel("Park So-dam", "Ki-jung Kim", "https://media.themoviedb.org/t/p/w500/gaDnEiMD5PClT9ARg1bSFyexbor.jpg"),
    CastModel("Jang Hye-jin", "Chung-sook Kim", "https://media.themoviedb.org/t/p/w500/pZiQXSWwo9F4gncHfa1yw0CQjxk.jpg"),
    CastModel("Park Myung-hoon", "Geun-se", "https://media.themoviedb.org/t/p/w500/5SucrxkigHss7UuJKrkfAZX5MXz.jpg"),
    CastModel("Lee Jung-eun", "Moon-gwang Park", "https://image.tmdb.org/t/p/original/45qpdANxxvU3danQPEhpGSQM9MX.jpg")
)

val shawshankCastList = listOf(
    CastModel("Tim Robbins", "Andy Dufresne", "image"),
    CastModel("Morgan Freeman", "Ellis Boyd \"Red\" Redding", "image"),
    CastModel("Bob Gunton", "Warden Samuel Norton", "image"),
    CastModel("William Sadler", "Heywood", "image"),
    CastModel("Clancy Brown", "Captain Byron Hadley", "image"),
    CastModel("Gil Bellows", "Tommy Williams", "image"),
    CastModel("James Whitmore", "Brooks Hatlen", "image"),
    // Include other cast members as desired
)

val spiderVerseCastList = listOf(
    // Spider-Man: Into the Spider-Verse (2018)
    CastModel("Shameik Moore", "Miles Morales / Spider-Man", "image"),
    CastModel("Hailee Steinfeld", "Gwen Stacy / Spider-Woman", "image"),
    CastModel("Jake Johnson", "Peter Parker / Spider-Man Noir", "image"),
    CastModel("John Mulaney", "Peter Parker / Spider-Ham", "image"),
    CastModel("Kimiko Glenn", "Peni Parker / SP//dr", "image"),
    CastModel("Nicolas Cage", "Peter Parker / Spider-Man Noir (voice)", "image"),
    CastModel("Liev Schreiber", "Kingpin / Wilson Fisk", "image"),
    CastModel("Mahershala Ali", "Aaron Davis / Prowler", "image"),
    CastModel("Brian Tyree Henry", "Jefferson Davis", "image"),
    CastModel("Kathryn Hahn", "Olivia Octavius / Doc Ock", "image"),
    CastModel("Lauren Vélez", "Rio Morales", "image"),
    CastModel("Lily Tomlin", "Aunt May Parker", "image"),
    CastModel("Chris Pine", "Peter Parker / Spider-Man (voice)", "image"),
    CastModel("Zoe Kravitz", "Mary Jane Watson", "image"),
    // Spider-Man: Across the Spider-Verse (2023)
    CastModel("Oscar Isaac", "Miguel O'Hara / Spider-Man 2099", "image"),  // Added for Across the Spider-Verse
    CastModel("Issa Rae", "Jessica Drew / Spider-Woman", "image"),  // Added for Across the Spider-Verse
    CastModel("Andy Samberg", "Ben Reilly / Scarlet Spider", "image"),  // Added for Across the Spider-Verse
    CastModel("Amandla Stenberg", "Margo Kess / Spider-Byte", "image"),  // Added for Across the Spider-Verse
    CastModel("Taran Killam", "Patrick O'Hara / Web-Slinger", "image"),  // Added for Across the Spider-Verse
    CastModel("Nic Novicki", "Peter Parker / Lego Spider-Man", "image"),  // Added for Across the Spider-Verse
    CastModel("Josh Keaton", "Peter Parker / Spectacular Spider-Man (voice)", "image"),  // Added for Across the Spider-Verse
    CastModel("Yuri Lowenthal", "Peter Parker / Insomniac Spider-Man (voice)", "image"),  // Added for Across the Spider-Verse
    CastModel("Mike Rianda", "Ezekiel Sims / Spider-Therapist", "image"),  // Added for Across the Spider-Verse
    CastModel("Sofia Barclay", "Malala Windsor / Spider-UK", "image"),  // Added for Across the Spider-Verse
    CastModel("Danielle Perez", "Charlotte Webber / Sun-Spider", "image"),  // Added for Across the Spider-Verse
    CastModel("Metro Boomin", "Metro Spider-Man", "image"),  // Added for Across the Spider-Verse

    // Include additional cast members for Across the Spider-Verse if desired
)