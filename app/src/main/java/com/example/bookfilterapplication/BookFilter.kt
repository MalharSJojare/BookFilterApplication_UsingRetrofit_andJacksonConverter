package com.example.bookfilterapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.lang.StringBuilder

class BookFilter : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_filter)
        val txtIpCountry=findViewById<TextInputLayout>(R.id.textInputLayout_country)
        val txtIpYear=findViewById<TextInputLayout>(R.id.textInputLayout_year)
        val btn=findViewById<Button>(R.id.Button_SearchBook)
        val txtOpBook=findViewById<TextView>(R.id.TextView_BookList)
        val lstOpView=findViewById<TextView>(R.id.listView_booklist)
        txtOpBook.setVisibility(View.INVISIBLE)
        Log.d("Screen","Working1")
        btn.setOnClickListener{
            val IPYear= txtIpYear.editText?.text.toString().toInt()
            val IPCount= txtIpCountry.editText?.text.toString()
            var count=0
            val bookApplication=application as BookApplication
            val bookService=bookApplication.books
            Log.d("Screen","Working2")
            CoroutineScope(Dispatchers.IO).launch {
                val decodedBook=bookService.getBooks()
                Log.d("Screen","Working3")
                withContext(Dispatchers.Main)
                {
                    val myStringBuilder = StringBuilder()
                    Log.d("Screen","Working4")
                    for (myData in decodedBook) {
                        Log.d("Screen","Working5")
                        if (IPYear == myData.year || IPCount == myData.country) {
                            if(count<3) {
                                myStringBuilder.append("Result : "+myData.title)
                                myStringBuilder.append("\n")
                                Log.d("Screen","Working6")
                            }
                            count++
                        }
                    }
                    lstOpView.text = "Results : "+count+"\n$myStringBuilder"
                    Log.d("Screen","Working7")
                }
        }
        }
    }
}

