package com.example.retrofit

import YourAdapter
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myApis = RetrofitClient.retrofit.create(UserApis::class.java)
        val callProduct = myApis.getProductById()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = YourAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        callProduct.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                val product = response.body()
                if (product != null) {
                    val productList = listOf(product)
                    adapter.setProductList(productList)
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("myy", "API call failed: ${t.message}")
            }
        })
    }
}
