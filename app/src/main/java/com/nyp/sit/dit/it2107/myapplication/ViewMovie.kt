package com.nyp.sit.dit.it2107.myapplication

import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

class ViewMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie)
        setTitle("MovieRater")
//        // Get the Intent that started this activity and extract the string
//        val movie_name_view:String? = intent.getStringExtra(movie_name_view_msg)
//        val movie_description_view:String? = intent.getStringExtra(movie_description_view_msg)
//        val language_view:String? = intent.getStringExtra(language_view_msg)
//        val date_view:String? = intent.getStringExtra(release_date_view_msg)
//        val suitable_view:String? = intent.getStringExtra(suitable_view_msg)
//        val reason1_view:String? = intent.getStringExtra(reason1_view_msg)
//        val reason2_view:String? = intent.getStringExtra(reason2_view_msg)
//
        // Capture the layout's TextView and set the string as its text

        var movie = MovieEntity("Venom","When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life.","English","03-10-2018","Yes")

        val textView = findViewById<TextView>(R.id.movie_name_view).apply {
            text = movie.movie_title
        }

        val movie_description_textView = findViewById<TextView>(R.id.movie_description_view).apply {
            text = movie.movie_description
        }

        val language_textView = findViewById<TextView>(R.id.language_view).apply {
            text = movie.language
        }

        val date_textView = findViewById<TextView>(R.id.date_view).apply {
            text = movie.release_date
        }

        val suitable_textView = findViewById<TextView>(R.id.suitable_view).apply {
            text = movie.suitable
        }



    }
}
