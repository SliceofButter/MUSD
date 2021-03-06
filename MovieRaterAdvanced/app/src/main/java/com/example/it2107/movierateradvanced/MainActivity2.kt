package com.example.it2107.movierateradvanced

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.io.Serializable

class MainActivity2 : AppCompatActivity() {

    var checkViolence = ""
    var checkLanguage = ""
    var checkSuitable = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val check2 = findViewById<CheckBox>(R.id.checkBox2)
        check2.visibility = View.GONE
        val check3 = findViewById<CheckBox>(R.id.checkBox4)
        check3.visibility = View.GONE
        val check = findViewById<CheckBox>(R.id.checkBox)
        check.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                check2.visibility = View.VISIBLE
                check3.visibility = View.VISIBLE
            }
            else {
                check2.visibility = View.GONE
                check2.isChecked = false
                check3.visibility = View.GONE
                check3.isChecked = false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?):
            Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.menu_register )
        {
            val name = findViewById<EditText>(R.id.movieName)
            var desc = findViewById<EditText>(R.id.editText4)
            var date = findViewById<EditText>(R.id.editText5)
            val check2 = findViewById<CheckBox>(R.id.checkBox2)
            check2.visibility = View.GONE
            val check3 = findViewById<CheckBox>(R.id.checkBox4)
            check3.visibility = View.GONE
            val check = findViewById<CheckBox>(R.id.checkBox)
            if(name.text.isNullOrEmpty())
            {
                name.setError("Field Empty!Enter a valid movie name!")
            }
            if(desc.text.isNullOrEmpty())
            {
                desc.setError("Field Empty! Enter a Description!")
            }
            if(date.text.isNullOrEmpty())
            {
                date.setError("Field Empty! Enter a Date!")
            }
            var radiocheck = findViewById<RadioGroup>(R.id.radio_group)
            var radioid:Int = radiocheck.checkedRadioButtonId
            if(radioid != -1) {
                val radio1: RadioButton = findViewById(radioid)
                if(check.isChecked) {
                    if(check2.isChecked && check3.isChecked == false) {
                        checkViolence ="Violence"
                        checkLanguage = ""
                    }
                    else if(check3.isChecked && check2.isChecked == false) {
                        checkLanguage= "Language Used"
                        checkViolence = ""
                    }
                    else if (check2.isChecked && check3.isChecked)
                    {
                        checkViolence ="Violence"
                        checkLanguage= "Language Used"
                    }
                    val movie = applicationContext as Movie
                    val intent = Intent(applicationContext, MainActivity3::class.java)
                    val movieDeets = movieItem(name.text.toString(),
                    desc.text.toString(),
                    radio1.text.toString(),
                    date.text.toString(),
                     "No",
                        checkLanguage,
                        checkViolence)

                    movie.addMovie(movieDeets)
                    startActivity(intent)
                }

                else if(check.isChecked == false)
                {
                    val movie = applicationContext as Movie
                    val intent = Intent(applicationContext, MainActivity3::class.java)
                    val movieDeets = movieItem(name.text.toString(),
                        desc.text.toString(),
                        radio1.text.toString(),
                        date.text.toString(),
                        "Yes",
                        checkLanguage,
                        checkViolence)
                    movie.addMovie(movieDeets)
                    startActivity(intent)
                }
            }

        }
        else if(item?.itemId == R.id.menu_clear)
        {
            val name = findViewById<EditText>(R.id.movieName)
            var desc = findViewById<EditText>(R.id.editText4)
            var date = findViewById<EditText>(R.id.editText5)
            val check2 = findViewById<CheckBox>(R.id.checkBox2)
            val check3 = findViewById<CheckBox>(R.id.checkBox4)
            val check = findViewById<CheckBox>(R.id.checkBox)
            var engbutton = findViewById<RadioButton>(R.id.engButton)
            name.text.clear()
            desc.text.clear()
            date.text.clear()
            check2.isChecked = false
            check3.isChecked = false
            check.isChecked = false
            engbutton.isChecked = true
        }
        return super.onOptionsItemSelected(item)
    }
}
