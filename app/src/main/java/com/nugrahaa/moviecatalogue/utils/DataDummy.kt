package com.nugrahaa.moviecatalogue.utils

import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.MovieEntity
import com.nugrahaa.moviecatalogue.model.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity("A Star Is Born",
            "Oktober 3, 2018",
            "Drama, Romance, Music",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "2h 16m", R.drawable.poster_a_start_is_born))

        movies.add(MovieEntity("Alita: Battle Angel",
            "Januari 31, 2019",
            "Action, Science Fiction, Adventure",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "2h 2m", R.drawable.poster_alita))

        movies.add(MovieEntity("Aquaman",
            "Desember 7, 2018",
            "Action, Adventure, Fantasy",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "2h 24m", R.drawable.poster_aquaman))

        movies.add(MovieEntity("Bohemian Rhapsody",
            "Oktober 24, 2018",
            "Drama, Music",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "2h 15m", R.drawable.poster_bohemian))

        movies.add(MovieEntity("Cold Pursuit",
            "Februari 7, 2019",
            "Action, Crime, Thriller",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "1h 59m", R.drawable.poster_cold_persuit))

        movies.add(MovieEntity("Creed",
            "November 25, 2015",
            "Drama",
            "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            "2h 13m", R.drawable.poster_creed))

        movies.add(MovieEntity("Fantastic Beasts: The Crimes of Grindelwald",
            "November 14, 2018",
            "Adventure, Fantasy, Drama",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "2h 14m", R.drawable.poster_crimes))

        movies.add(MovieEntity("Glass",
            "Januari 16, 2019",
            "Thriller, Drama, Science Fiction",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "2h 9m", R.drawable.poster_glass))

        movies.add(MovieEntity("How to Train Your Dragon: The Hidden World",
            "Januari 3, 2019",
            "Animation, Family, Adventure",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "1h 44m", R.drawable.poster_how_to_train))

        movies.add(MovieEntity("Avengers: Infinity War",
            "April 25, 2018",
            "Adventure, Action, Science Fiction",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "2h 29m", R.drawable.poster_infinity_war))

        movies.add(MovieEntity("Spider-Man: Into the Spider-Verse",
            "Desember 6, 2018",
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "1h 57m", R.drawable.poster_spiderman))

        return movies

    }

    fun generateDummyTvShows(): ArrayList<TvShowEntity> {

        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(TvShowEntity("Arrow",
            "Oktober 10, 2012",
            "Crime, Drama, Mystery, Action & Adventure",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "42m", R.drawable.poster_arrow))

        tvShows.add(TvShowEntity("Doom Patrol",
            "Februari 15, 2019",
            "Sci-Fi & Fantasy, Action & Adventure",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "49m", R.drawable.poster_doom_patrol))

        tvShows.add(TvShowEntity("Dragon Ball Z",
            "April 26, 1989",
            "Sci-Fi & Fantasy, Animation, Comedy, Action & Adventure",
            "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
            "26m", R.drawable.poster_dragon_ball))

        tvShows.add(TvShowEntity("Fairy Tail",
            "Oktober 12, 2009",
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "25m", R.drawable.poster_fairytail))

        tvShows.add(TvShowEntity("Family Guy",
            "Januari 31, 1999",
            "Animation, Comedy",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "22m", R.drawable.poster_family_guy))

        tvShows.add(TvShowEntity("The Flash",
                "Oktober 7, 2014",
                "Drama, Sci-fi & Fantasy",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it wont be long before the world learns what Barry Allen has become...The Flash.",
                "44m", R.drawable.poster_flash))

        tvShows.add(TvShowEntity("Grey's Anatomy",
                "Maret 27, 2005",
                "Drama",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "43m", R.drawable.poster_grey_anatomy))

        tvShows.add(TvShowEntity("Marvel's Iron Fist",
                "Maret 17, 2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "55m", R.drawable.poster_iron_fist))

        tvShows.add(TvShowEntity("Riverdale",
                "Januari 26, 2017",
                "Drama, Mystery",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "45m", R.drawable.poster_riverdale))

        tvShows.add(TvShowEntity("Shameless",
                "Januari 9, 2011",
                "Drama, Comedy",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "1h", R.drawable.poster_shameless))

        tvShows.add(TvShowEntity("Supergirl",
                "Oktober 26, 2015",
                "Action, Adventure, Drama, Science Fiction",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "42m", R.drawable.poster_supergirl))

        return tvShows
    }

}