package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewTask = findViewById<ListView>(R.id.listView)

        val taskList = arrayListOf<String>()
        taskList.add("Visit CP Hanuman Mandir")
        taskList.add("Attend Exam")
        taskList.add("Complete the App Dev Project")
        taskList.add("Buy vegetables from Market")
        taskList.add("Work on resume")
        taskList.add("Improve Internet presence")

        val adapterForMyListView = ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList)
        listViewTask.adapter = adapterForMyListView

        listViewTask.setOnItemClickListener { adapterView, view, i, l ->
            val text = "Clicked on item : " + (view as TextView).text.toString()
            Toast.makeText(this, text,Toast.LENGTH_SHORT).show()
        }


    }
}

