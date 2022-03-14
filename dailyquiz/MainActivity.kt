package com.example.dailyquiz

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val btn_start=findViewById<Button>(R.id.btn_start)
        val et_name=findViewById<EditText>(R.id.et_name)
            btn_start.setOnClickListener{
                if (et_name.text.isEmpty()){
                    Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
            val intent= Intent(this,quizquestions::class.java)
                    startActivity(intent)
                    finish()
            }


       }
    }
}