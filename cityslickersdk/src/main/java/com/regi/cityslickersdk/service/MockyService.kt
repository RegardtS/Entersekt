package com.regi.cityslickersdk.service

import com.regi.cityslickersdk.model.CitiesApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MockyService{

   @GET("5b7e8bc03000005c0084c210?mocky-delay=4000ms")
   fun getAllCities(): Call<CitiesApiResponse>

   companion object Factory{
      fun create(): MockyService{
         val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.mocky.io/v2/")
            .build()
         return  retrofit.create(MockyService::class.java)
      }
   }
}