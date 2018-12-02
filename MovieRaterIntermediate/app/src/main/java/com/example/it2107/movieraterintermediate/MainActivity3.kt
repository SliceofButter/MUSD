package com.example.it2107.movieraterintermediate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val movie = findViewById<TextView>(R.id.movie)
        val mtext:String = intent.extras.getString("moviename")
        val overview = findViewById<TextView>(R.id.overview)
        val otext:String = intent.extras.getString("description")
        val date = findViewById<TextView>(R.id.date)
        val dtext:String = intent.extras.getString("date")
        val language = findViewById<TextView>(R.id.language)
        val ltext:String = intent.extras.getString("language")
        val age = findViewById<TextView>(R.id.suitable)
        val atext:String = intent.extras.getString("age")

        movie.text = mtext
        overview.text = otext
        date.text = dtext
        language.text = ltext
        age.text = atext
    }

}
