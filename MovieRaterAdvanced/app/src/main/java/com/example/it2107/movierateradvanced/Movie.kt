package com.example.it2107.movierateradvanced

import android.app.Application

class Movie: Application() {

    var movieTitle ="";

    fun getTitle():String{
        return movieTitle
    }
    fun setTitle(movieTitle: String)
    {
        this.movieTitle = movieTitle
    }

    var movieDesc = "";

    fun getDesc():String{
        return movieDesc
    }
    fun setDesc(movieDesc:String)
    {
        this.movieDesc = movieDesc
    }

    var lang = ""

    fun getLanguage():String
    {
        return lang
    }
    fun setLanguage(lang:String)
    {
        this.lang = lang
    }

    var releaseDate = ""

    fun getDate():String
    {
        return releaseDate
    }
    fun setDate(releaseDate:String)
    {
        this.releaseDate = releaseDate
    }

    var suitable =""

    fun getSuit():String
    {
        return suitable
    }
    fun setSuit(suitable:String)
    {
        this.suitable = suitable
    }

    var review = "Long Press here to add review"

    fun getMReview():String
    {
        return review
    }
    fun setMReview(review:String)
    {
        this.review = review
    }

    var rateStars:Float = 0F
    fun getrStars():Float
    {
        return rateStars
    }
    fun setrStars(mStars:Float)
    {
        this.rateStars = mStars
    }

    var langused = ""

    fun getlangused():String
    {
        return langused
    }
    fun setlangused(languse:String)
    {
        this.langused = languse
    }

    var violent = ""

    fun getVio():String{
        return violent
    }
    fun setVio(violence:String)
    {
        this.violent = violence
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