package com.example.it2107.movieraterintermediate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val movie = applicationContext as Movie

        val moviet = findViewById<TextView>(R.id.movie)
        val overview = findViewById<TextView>(R.id.overview)
        val date = findViewById<TextView>(R.id.date)
        val language = findViewById<TextView>(R.id.language)
        val age = findViewById<TextView>(R.id.suitable)


        moviet.text = movie.getTitle()
        overview.text = movie.getDesc()
        date.text = movie.getDate()
        language.text = movie.getLanguage()
        if(movie.getSuit() == "No")
        {
            if(movie.getlangused() == "Language Used") {
                age.text = movie.getSuit()
            }
            else if(movie.getVio() == "Violence")
            {
                age.text = movie.getSuit() + "(" + movie.getVio() + ")"
            }
            else if (movie.getlangused() == "Language Used" && movie.getVio() == "Violence" )
            {
                age.text = movie.getSuit() + "(" + movie.getlangused() + ", " + movie.getVio()+")"
            }

        }
        else
        {
            age.text = movie.getSuit()
        }

    }

}
