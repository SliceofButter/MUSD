package com.example.it2107.movierating

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val check2 = findViewById<CheckBox>(R.id.checkBox2)
        check2.visibility = View.GONE
        val check3 = findViewById<CheckBox>(R.id.checkBox4)
        check3.visibility = View.GONE
        val check = findViewById<CheckBox>(R.id.checkBox)
        check.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                check2.visibility = View.VISIBLE
                check3.visibility = View.VISIBLE
            } else {
                check2.visibility = View.GONE
                check2.isChecked = false
                check3.visibility = View.GONE
                check3.isChecked = false
            }
        }

        val button = findViewById<Button>(R.id.addButton)
        button.setOnClickListener {
            val name = findViewById<EditText>(R.id.movieName)
            var desc = findViewById<EditText>(R.id.editText4)
            var date = findViewById<EditText>(R.id.editText5)
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
                val message = "Title = " + name.text + "\n" + "Overview =  " + desc.text + "\n" + "Release Date = " + date.text + "\n" + "Language = " +radio1.text+"\n" + "Not Suitable for all ages =" + check.isChecked
                if(check.isChecked)
                {
                    val reason = "\n" + "Reason: " + "\n"
                    if(check2.isChecked && check3.isChecked == false)
                    {
                        val extra = "Violence"
                        val new = reason + extra
                        val message1= message + new
                        Toast.makeText(this, message1, Toast.LENGTH_LONG).show()
                    }
                    else if(check3.isChecked && check2.isChecked == false)
                    {
                        val extra = "Language Used"
                        val new = reason + extra
                        val message1= message + new
                        Toast.makeText(this, message1, Toast.LENGTH_LONG).show()
                    }
                    else if (check2.isChecked && check3.isChecked)
                    {
                        val extra = "Violence" +"\n" +"Language Used"
                        val new = reason + extra
                        val message2= message + new
                        Toast.makeText(this, message2, Toast.LENGTH_LONG).show()
                    }
                }
                else {
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                }
            }
        }
        val view =  findViewById<Button>(R.id.viewButton)
        view.setOnClickListener {
            val name = findViewById<EditText>(R.id.movieName)
            var desc = findViewById<EditText>(R.id.editText4)
            var date = findViewById<EditText>(R.id.editText5)
            var radiocheck = findViewById<RadioGroup>(R.id.radio_group)
            var radioid:Int = radiocheck.checkedRadioButtonId
            val radio1: RadioButton = findViewById(radioid)
            if(check.isChecked) {
                val no = "No"
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("moviename", name.text.toString())
                intent.putExtra("description", desc.text.toString())
                intent.putExtra("date", date.text.toString())
                intent.putExtra("language", radio1.text.toString())
                intent.putExtra("age", no)
                startActivity(intent)
            }
            else if(check.isChecked == false)
            {
                val yes = "Yes"
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("moviename", name.text.toString())
                intent.putExtra("description", desc.text.toString())
                intent.putExtra("date", date.text.toString())
                intent.putExtra("language", radio1.text.toString())
                intent.putExtra("age", yes)
                startActivity(intent)
            }
        }
        val rate = findViewById<Button>(R.id.rateButton)
        rate.setOnClickListener{
            val name = findViewById<EditText>(R.id.movieName)
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("moviename", name.text.toString())
            startActivity(intent)
        }

    }


}
