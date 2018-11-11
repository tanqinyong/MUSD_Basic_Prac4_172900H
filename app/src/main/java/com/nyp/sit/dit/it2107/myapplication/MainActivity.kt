package com.nyp.sit.dit.it2107.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (movie_name.text.isNullOrEmpty()) {
                movie_name.setError("Field Empty")
            }
            if(movie_description.text.isNullOrEmpty()) {
                movie_description.setError("Field Empty")
            }
            if(release_date.text.isNullOrEmpty()) {
                release_date.setError("Field Empty")
            }
        }

        // set default selection for radio button ?
        default_radio.isChecked = true
    }

    fun chkbx_show(v:View) {
        if (chkbx1.isChecked==true) {
            chkbx2.visibility = View.VISIBLE
            chkbx3.visibility = View.VISIBLE
            chkbx2.isChecked = true
            chkbx3.isChecked = true
        }
        else {
            chkbx2.visibility = View.INVISIBLE
            chkbx3.visibility = View.INVISIBLE
            chkbx2.isChecked = false
            chkbx3.isChecked = false
        }

    }
}
