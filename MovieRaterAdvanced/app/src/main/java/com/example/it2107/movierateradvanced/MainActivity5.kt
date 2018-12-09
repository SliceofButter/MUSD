package com.example.it2107.movierateradvanced

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val movie = applicationContext as Movie
        val name = findViewById<EditText>(R.id.movieName)
        var desc = findViewById<EditText>(R.id.editText4)
        var date = findViewById<EditText>(R.id.editText5)
        name.setText(movie.getTitle())
        desc.setText(movie.getDesc())
        date.setText(movie.getDate())
        if(movie.getLanguage()=="English")
        {
            engButton1.isChecked == true
        }
        else if(movie.getLanguage()=="Chinese")
        {
            chButton1.isChecked == true
        }
        else if(movie.getLanguage()=="Malay")
        {
            malayButton1.isChecked == true
        }
        else if(movie.getLanguage()=="Tamil")
        {
            tamilButton1.isChecked == true
        }
        val check2 = findViewById<CheckBox>(R.id.checkBox2)
        check2.visibility = View.GONE
        val check3 = findViewById<CheckBox>(R.id.checkBox4)
        check3.visibility = View.GONE
        if(movie.getlangused()== "true")
        {
            check3.visibility = View.VISIBLE
            check3.isChecked
        }
        else if (movie.getVio()=="true")
        {
            check2.visibility = View.VISIBLE
            check2.isChecked
        }
        else if (movie.getVio() == "true" && movie.getlangused() == "true") {
            check3.visibility = View.VISIBLE
            check2.visibility = View.VISIBLE
            check3.isChecked
            check2.isChecked
        }
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
        menuInflater.inflate(R.menu.editmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.menu_save )
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
                    val movie = applicationContext as Movie
                    val intent = Intent(applicationContext, MainActivity3::class.java)
                    movie.setTitle(name.text.toString())
                    movie.setDesc(desc.text.toString())
                    movie.setDate(date.text.toString())
                    movie.setLanguage(radio1.text.toString())
                    movie.setSuit("No")
                    if(check2.isChecked && check3.isChecked == false) {
                        movie.setVio("true")
                        movie.setSuit("No(Violence)")
                    }
                    else if(check3.isChecked && check2.isChecked == false) {
                        movie.setlangused("true")
                        movie.setSuit("No(Language Used)")
                    }
                    else if (check2.isChecked && check3.isChecked)
                    {
                        movie.setlangused("true")
                        movie.setVio("true")
                        movie.setSuit("No(Violence & Language Used)")
                    }
                    startActivity(intent)
                }

                else if(check.isChecked == false)
                {
                    val movie = applicationContext as Movie
                    val intent = Intent(applicationContext, MainActivity3::class.java)
                    movie.setTitle(name.text.toString())
                    movie.setDesc(desc.text.toString())
                    movie.setDate(date.text.toString())
                    movie.setLanguage(radio1.text.toString())
                    movie.setSuit("Yes")
                    startActivity(intent)
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

}
