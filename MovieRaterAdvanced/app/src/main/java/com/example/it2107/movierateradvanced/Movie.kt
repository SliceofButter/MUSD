package com.example.it2107.movierateradvanced

import android.app.Application
class movieItem(movieTitle:String, movieDesc: String, lang:String,releaseDate: String,suitable: String,langused: String, violent:String )
{
    var movieTitle = movieTitle
    var movieDesc = movieDesc
    var lang = lang
    var releaseDate = releaseDate
    var suitable = suitable
    var review = "Long Press here to add review"
    var rateStars:Float = 0F
    var langused = langused
    var violent = violent

}
class Movie: Application() {


    var movieArray:ArrayList<movieItem>
    init {
        this.movieArray= arrayListOf()
    }
    fun addMovie(newMovieEntity: movieItem){
        this.movieArray.add(newMovieEntity)
    }

    fun getMovie():ArrayList<movieItem>{
        return this.movieArray
    }

    private var testin:Movie? = null

    fun getInstance():Movie?
    {
        return testin
    }

    override fun onCreate()
    {
        super.onCreate()
        testin = this
    }

}