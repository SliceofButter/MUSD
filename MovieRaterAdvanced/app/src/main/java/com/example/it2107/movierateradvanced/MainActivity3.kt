package com.example.it2107.movierateradvanced

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.ContextMenu
import android.view.MenuItem
import android.widget.RatingBar
import android.widget.TextView
import android.view.View
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val rate = findViewById<RatingBar>(R.id.ratingBar2)
        rate.visibility = View.GONE


        val movie = applicationContext as Movie
        var position = intent.getIntExtra("position", -1)
        val movieDeets : movieItem
        if(position > 0 || position == 0)
        {
            movieDeets = movie.getMovie().elementAt(position)
        }
        else
        {
            movieDeets = movie.getMovie().last()
        }

        val moviet = findViewById<TextView>(R.id.movie)
        val overview = findViewById<TextView>(R.id.overview)
        val date = findViewById<TextView>(R.id.date)
        val language = findViewById<TextView>(R.id.language)
        val age = findViewById<TextView>(R.id.suitable)


        moviet.text = movieDeets.movieTitle
        overview.text = movieDeets.movieDesc
        date.text = movieDeets.releaseDate
        language.text = movieDeets.lang
        if(movieDeets.suitable == "No")
        {
            age.text = movieDeets.suitable

            if(movieDeets.langused == "Language Used" && movieDeets.violent =="") {
                age.text = movieDeets.suitable +"(" + movieDeets.langused+ ")"
            }
            else if(movieDeets.violent == "Violence" && movieDeets.langused == "")
            {
                age.text = movieDeets.suitable +"(" + movieDeets.violent+ ")"
            }
            else if (movieDeets.langused == "Language Used" && movieDeets.violent =="Violence" )
            {
                age.text = movieDeets.suitable +"(" + movieDeets.langused+", "+movieDeets.violent+ ")"
            }

        }
        else if(movieDeets.suitable == "Yes")
        {
            age.text = movieDeets.suitable
        }

        if(movieDeets.rateStars>0F)
        {
            ratingBar2.layoutParams.height=ActionBar.LayoutParams.WRAP_CONTENT
            ratingBar2.rating = movieDeets.rateStars
            ratingBar2.visibility = View.VISIBLE
            review.text = movieDeets.review
        }

        registerForContextMenu(review)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if(v?.id == R.id.review)
        {
            menu?.add(1,1001,1,"Add Review")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(applicationContext,MainActivity4::class.java)
        if(item?.itemId== 1001)
        {
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }

}
