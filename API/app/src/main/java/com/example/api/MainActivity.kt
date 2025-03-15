package com.example.api

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    private lateinit var productRecyclerView : RecyclerView
    lateinit var productAdapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productRecyclerView = findViewById(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(p0: Call<MyData?>, p1: Response<MyData?>) {
                // if api call is a success, then use the data of API and show in your app
                val responseBody = p1.body()
                val productList = responseBody?.products!!

                productAdapter = ProductAdapter(this@MainActivity,productList)
                productRecyclerView.adapter = productAdapter
                productRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(p0: Call<MyData?>, p1: Throwable) {
                // if api call fails
                Log.d("Main Activity ", "onFailure: " + p1.message)
            }
        })

    }
}