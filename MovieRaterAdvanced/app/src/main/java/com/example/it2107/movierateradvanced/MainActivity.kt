package com.example.it2107.movierateradvanced

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(listView)
        val movie = applicationContext as Movie
        if(movie.getMovie().isNotEmpty()) {
            val adapter = movieAdapter(applicationContext, movie.getMovie())
            listView.adapter = adapter
            listView.setOnItemClickListener { _, _, position, _ ->
                val intent = Intent(this,MainActivity3::class.java)
                intent.putExtra("position",position)
                startActivity(intent)
            }
        }


    }
    class movieAdapter( private val context: Context,
        private val dataSource: ArrayList<movieItem>) : BaseAdapter() {

        private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return dataSource.size
        }

        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val row = inflater.inflate(R.layout.listviewlayout, parent, false)
            val movieitem = getItem(position) as movieItem
            val moviename = row.findViewById<TextView>(R.id.titleName)
            val thumbnail = row.findViewById<ImageView>(R.id.thumbnail)
            moviename.text = movieitem.movieTitle
            thumbnail.setImageResource(R.drawable.movie)

            return row
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intention = Intent(applicationContext,MainActivity2::class.java )
        startActivity(intention)
        return super.onOptionsItemSelected(item)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v:
    View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.listView) {
            menu?.add(1, 1001, 1, "Edit")
        }

    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
        if(item.itemId == 1001)
        {
            val intent = Intent(this@MainActivity, MainActivity5::class.java)
            intent.putExtra("position",info.id.toInt())
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }


}
