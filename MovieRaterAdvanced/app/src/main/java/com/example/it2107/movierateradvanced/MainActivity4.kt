package com.example.it2107.movierateradvanced

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val movie = applicationContext as Movie
        val movieDeets = movie.getMovie().last()
        movieName.text = movieDeets.movieTitle
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.reviewmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val movie = applicationContext as Movie
        val movieDeets = movie.getMovie().last()
        movieDeets.rateStars = ratingBar.rating
        movieDeets.review = rating.text.toString()
        val intent = Intent(applicationContext,MainActivity3::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}