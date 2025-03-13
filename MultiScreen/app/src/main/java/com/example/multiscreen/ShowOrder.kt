package com.example.multiscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.multiscreen.databinding.ActivityShowOrderBinding


class ShowOrder : AppCompatActivity() {

    private lateinit var binding: ActivityShowOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val ordersOfCustomer= intent.getStringExtra(MainActivity.KEY)

        binding.tvOrder.text= ordersOfCustomer.toString()
    }
}
