package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface UserApis {


    @GET("/products/1")

fun getProductById():Call<Product>

}