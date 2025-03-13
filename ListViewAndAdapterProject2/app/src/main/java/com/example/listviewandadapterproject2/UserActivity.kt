package com.example.listviewandadapterproject2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")
        val imageId = intent.getIntExtra("imageId", R.drawable.img)

        val nameTv = findViewById<TextView>(R.id.tvName)
        val phoneTv = findViewById<TextView>(R.id.tvPhone)
        val imageDp = findViewById<CircleImageView>(R.id.profile_image)

        nameTv.text = "Name : $name"
        phoneTv.text = "Phone Number : $phoneNumber"
        imageDp.setImageResource(imageId)

    }
}
