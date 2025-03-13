package com.example.multiscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multiscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // creating key
    companion object {
        const val KEY = "com.example.multiscreen.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnOrder.setOnClickListener {
            val ordersList= binding.eT1.text.toString()+" "+ binding.eT2.text.toString()+" "+
                    binding.eT3.text.toString()+" "+binding.eT4.text.toString()

            intent= Intent(this, ShowOrder::class.java)
            intent.putExtra(KEY,ordersList)
            startActivity(intent)
        }


    }
}

