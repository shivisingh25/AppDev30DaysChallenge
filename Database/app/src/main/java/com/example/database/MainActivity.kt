package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    lateinit var database :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signButton = findViewById<Button>(R.id.btnSignUp)
        val etName= findViewById<TextInputEditText>(R.id.eTName)
        val etMail=findViewById<TextInputEditText>(R.id.eTMail)
        val userId=findViewById<TextInputEditText>(R.id.eTUsername)
        val userPassword=findViewById<TextInputEditText>(R.id.eTPassword)

        signButton.setOnClickListener {
            val name = etName.text.toString()
            val mail= etMail.text.toString()
            val uniqueId= userId.text.toString()
            val password= userPassword.text.toString()

            val user = User(name, mail, password, uniqueId)

            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                etName.text?.clear()
                etMail.text?.clear()
                userId.text?.clear()
                userPassword.text?.clear()
                Toast.makeText(this, "You have registered successfully!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                etName.text?.clear()
                etMail.text?.clear()
                userId.text?.clear()
                userPassword.text?.clear()
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
            }
        }

        val signInText = findViewById<TextView>(R.id.tvSignIn)

        signInText.setOnClickListener {
            val intentSignIn = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intentSignIn)
        }

    }
}