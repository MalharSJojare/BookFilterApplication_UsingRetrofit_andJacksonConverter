package com.example.bookfilterapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val welcomeTxtView=findViewById<TextView>(R.id.TextView_Welcome)
        welcomeTxtView.setOnClickListener{
            val newScreenIntent= Intent(this,BookFilter::class.java)
            startActivity(newScreenIntent)
        }
    }
}