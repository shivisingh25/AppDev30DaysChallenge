package com.example.photoframeapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    private lateinit var image: ImageView
    var names = arrayOf("Virat Kohli", "Saumya Singh", "Malala","Priyanka Chopra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val textName = findViewById<TextView>(R.id.textView)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (4+ currentImage - 1) % 4

            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

            textName.text = names[currentImage]

        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (4+ currentImage + 1) % 4

            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f

            textName.text = names[currentImage]
        }

    }
}

