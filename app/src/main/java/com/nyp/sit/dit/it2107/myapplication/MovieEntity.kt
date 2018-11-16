package com.nyp.sit.dit.it2107.myapplication

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MovieEntity(movie_title:String, movie_description:String, language:String, release_date:String, suitable:String) {
    var movie_title: String
    var movie_description:String
    var language: String
    var release_date: String
    var suitable: String

    init {
        this.movie_title = movie_title
        this.movie_description = movie_description
        this.language = language
        this.release_date = release_date
        this.suitable = suitable
    }

}