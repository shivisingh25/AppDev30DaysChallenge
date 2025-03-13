package com.example.listviewandadapterproject2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Shivangi", "Mitalee", "Aditya", "Neelam", "Prabhakar")

        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "Cool")

        val lastMsgTime = arrayOf("6:25AM", "3:12PM", "5:00PM", "6:25AM", "7:30PM")

        val phnNumber = arrayOf("1234567890", "9876543211","4569873201","8527419634","7413698520")

        val imgId = intArrayOf(R.drawable.img,R.drawable.pic4,R.drawable.pic1,R.drawable.pic3,R.drawable.pic2)

        userArrayList = ArrayList()

        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex],lastMsgTime[eachIndex],phnNumber[eachIndex],imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)

        listView.isClickable = true

        listView.adapter = MyAdapter(this, userArrayList)
        
        listView.setOnItemClickListener { adapterView, view, i, l ->
            // open a new activity

            val userName = name[i]
            val userPhone = phnNumber[i]
            val imageId = imgId[i]

            val intentUser = Intent(this, UserActivity::class.java)

            intentUser.putExtra("name", userName)
            intentUser.putExtra("phoneNumber", userPhone)
            intentUser.putExtra("imageId",imageId)
            startActivity(intentUser)
        }

    }
}
