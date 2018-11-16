package com.nyp.sit.dit.it2107.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.nyp.sit.dit.it2107.myapplication.R.layout.activity_view_movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.custom_toast.view.*
import org.w3c.dom.Text
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

//const val movie_name_view_msg = "com.nyp.sit.dit.it2107.myapplication.MOVIE_NAME_VIEW"
//const val movie_description_view_msg = "com.nyp.sit.dit.it2107.myapplication.MOVIE_DESCRIPTION_VIEW"
//const val release_date_view_msg = "com.nyp.sit.dit.it2107.myapplication.RELEASE_DATE_VIEW"
//const val language_view_msg = "com.nyp.sit.dit.it2107.myapplication.LANGUAGE_VIEW"
//const val suitable_view_msg = "com.nyp.sit.dit.it2107.myapplication.SUITABLE_VIEW"
//const val reason1_view_msg = "com.nyp.sit.dit.it2107.myapplication.REASON1_VIEW"
//const val reason2_view_msg = "com.nyp.sit.dit.it2107.myapplication.REASON2_VIEW"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var movie:MovieEntity;
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
                if( (movie_name.text.isNullOrEmpty()==false) && (movie_description.text.isNullOrEmpty()==false) && (release_date.text.isNullOrEmpty() == false) ) {

                    // set the language
                    val id = radioGroup.checkedRadioButtonId
                    var language = "language"
                    when (id) {
                            R.id.default_radio -> language="English"
                            R.id.radioChinese -> language="Chinese"
                            R.id.radioMalay -> language="Malay"
                            R.id.radioTamil -> language="Tamil"
                    }

                    // set the reason
                    var reason1 = ""
                    var reason2 = ""
                    if (chkbx2.isChecked == true) {
                        reason1 = "Violence"
                    }
                    if (chkbx3.isChecked == true) {
                        reason2 = "Language Used"
                    }

                    // variables and stuff for toast
                    var toast: Toast = Toast(this)
                    var release_date_toast = Date(release_date.text.toString())
                    var suitable_toast = chkbx1.isChecked

                    // toast
                    toast.createToast(this,movie_name.text.toString(),movie_description.text.toString(),
                            language, release_date_toast  , suitable_toast , reason1, reason2, Gravity.CENTER_VERTICAL, Toast.LENGTH_LONG)
                }
        }

        // set default selection for radio button ?
        default_radio.isChecked = true
    }

    fun Toast.createToast(context: Context, movie_name:String, movie_description:String, language:String, release_date:Date, suitable:Boolean, reason1:String, reason2:String, gravity:Int, duration:Int) {
        val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // first param is layout second param is root view in that xml
        val layout = inflater.inflate(R.layout.custom_toast, (context as Activity).findViewById<ViewGroup>(R.id.custom_toast_container))

        // to format the date
        val format = SimpleDateFormat("MM-dd-yyyy")
        // all the variables to display in toasties
        layout.findViewById<TextView>(R.id.movie_name).text = "Title = " + movie_name
        layout.findViewById<TextView>(R.id.movie_description).text = "Overview = " + movie_description
        layout.findViewById<TextView>(R.id.language).text = "Language = " + language
        layout.findViewById<TextView>(R.id.release_date).text = "Release date = " + format.format(release_date)
        layout.findViewById<TextView>(R.id.chkbx1).text = "Not suitable for all ages = " + suitable
        layout.findViewById<TextView>(R.id.chkbx2).text = reason1
        layout.findViewById<TextView>(R.id.chkbx3).text = reason2
        setGravity(Gravity.CENTER_VERTICAL,0,-10)
        setDuration(Toast.LENGTH_LONG);
        setView(layout);
        show()
    }

    fun chkbx_show(v:View) {
        if (chkbx1.isChecked==true) {
            chkbx2.visibility = View.VISIBLE
            chkbx3.visibility = View.VISIBLE
        }
        else {
            chkbx2.visibility = View.INVISIBLE
            chkbx3.visibility = View.INVISIBLE
            chkbx2.isChecked = false
            chkbx3.isChecked = false
        }
    }

    //
    // view movie?
//    fun sendMessage(view: View) {
//        val editText = findViewById<EditText>(R.id.editText)
//        val message = editText.text.toString()
//        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
//        }
//        startActivity(intent)
//    }

//        fun openActivityViewMovie(view: View) {
//            // set the language
//            val id = radioGroup.checkedRadioButtonId
//            var language = "language"
//            when (id) {
//                R.id.default_radio -> language="English"
//                R.id.radioChinese -> language="Chinese"
//                R.id.radioMalay -> language="Malay"
//                R.id.radioTamil -> language="Tamil"
//            }
//        // movie name
//        val movie_name = findViewById<TextView>(R.id.movie_name)
//        val movie_name_view = movie_name.text.toString()
//
//        // movie description
//        val movie_description = findViewById<TextView>(R.id.movie_description)
//        val movie_description_view = movie_description.text.toString()
//
//        // language
////        language = findViewById<TextView>(R.id.language)
//        val language_view = language
//
//        // date
//        val date = findViewById<TextView>(R.id.release_date)
//        val format = SimpleDateFormat("MM-dd-yyyy")
//        val date_view = format.format(Date(date.text.toString()))
//
//        // Suitable
//        val suitable = findViewById<TextView>(R.id.chkbx1)
//        val suitable_view = suitable.text.toString()
//
//        // Language used - reason
//        val reason1 = findViewById<TextView>(R.id.chkbx2)
//        val reason1_view = reason1.text.toString()
//
//        // Violence - reason
//        val reason2 = findViewById<TextView>(R.id.chkbx3)
//        val reason2_view = reason2.text.toString()
//
//        val intent = Intent(this, ViewMovie::class.java)
//        intent.putExtra(movie_name_view_msg,movie_name_view)
//        intent.putExtra(movie_description_view_msg,movie_description_view)
//        intent.putExtra(release_date_view_msg,date_view)
//        intent.putExtra(language_view_msg,language_view)
//        intent.putExtra(suitable_view_msg,suitable_view)
//        intent.putExtra(reason1_view_msg,reason1_view)
//        intent.putExtra(reason2_view_msg,reason2_view)
//
////         putExtra(EXTRA_MESSAGE, message)
////         ( keyIdentifier, value )
//        startActivity(intent)
//    }
}
