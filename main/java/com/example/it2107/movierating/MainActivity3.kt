package com.example.it2107.movierating

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val title = findViewById<TextView>(R.id.textView7)
        val ttext:String = intent.extras.getString("moviename")
        title.text = "Enter your review for this movie: " + ttext
    }
}
