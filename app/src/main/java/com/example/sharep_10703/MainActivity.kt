package com.example.sharep_10703

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var editTextName: EditText? = null
    var editTextEmail: EditText? = null
    lateinit var textViewName : TextView
    lateinit var textViewEmail: TextView
    private val myPreference ="myPref"
    private val name ="namekey"
    private val email="emailkey"
    var sharePreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        editTextEmail = findViewById(R.id.etEmail)
        editTextName = findViewById(R.id.etName)
        sharePreferences = getSharedPreferences(myPreference,Context.MODE_PRIVATE)

        if( sharePreferences!!.contains(name)){
            editTextName?.setText( sharePreferences!!.getString(name, ""))
        }

        if( sharePreferences!!.contains(email)){
            editTextName?.setText( sharePreferences!!.getString(email, ""))
        }
    }

    fun readData(view: View){
        textViewEmail = findViewById(R.id.textViewEmail)
        textViewName =  findViewById(R.id.textViewName)
        var strName: String = editTextName?.text.toString().trim()
        var strEmail: String = editTextEmail?.text.toString().trim()
        strName = sharePreferences!!.getString(name,"")!!
        strEmail = sharePreferences!!.getString(email,"")!!
        sharePreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE)

        if(sharePreferences!!.contains(name)){
            textViewName.text =strName
        }

        if(sharePreferences!!.contains(email)){
            textViewEmail.text = strEmail
        }
        Toast.makeText(baseContext, "Data retrieved", Toast.LENGTH_SHORT).show()
    }

    fun saveData(view: View){

        val strName: String = editTextName?.text.toString().trim()
        val strEmail: String = editTextEmail?.text.toString().trim()
        val editor: SharedPreferences.Editor = sharePreferences!!.edit()
        editor.putString(name, strName)
        editor.putString(email, strEmail)
        editor.apply()
        Toast.makeText(baseContext,"Saved", Toast.LENGTH_SHORT).show()
    }

    fun clearData(view: View){
        editTextName!!.text.clear()
        editTextEmail!!.text.clear()
        textViewName.text=""
        textViewEmail.text =""
        Toast.makeText(baseContext,"Cleared data", Toast.LENGTH_SHORT).show()
    }
}