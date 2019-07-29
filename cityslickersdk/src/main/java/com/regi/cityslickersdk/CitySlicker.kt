package com.regi.cityslickersdk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.regi.cityslickersdk.model.CitiesApiResponse
import com.regi.cityslickersdk.model.City
import com.regi.cityslickersdk.model.Mall
import com.regi.cityslickersdk.model.Shop
import com.regi.cityslickersdk.repo.MockyRepositoryProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CitySlicker {

    companion object {
        val instance = CitySlicker()
    }

    private var cityList = listOf<City>()
    private val repository = MockyRepositoryProvider.providePicRepository()
    private var errorString = MutableLiveData<String>()

    fun getError() = errorString

    fun getCityList(): LiveData<List<City>> {
        val data = MutableLiveData<List<City>>()
        repository.getCities().enqueue(object : Callback<CitiesApiResponse> {
            override fun onResponse(call: Call<CitiesApiResponse>, response: Response<CitiesApiResponse>) {
                data.value = response.body()?.cities
                cityList = response.body()?.cities!!
            }
            override fun onFailure(call: Call<CitiesApiResponse>, t: Throwable) {
                errorString.value = t.localizedMessage
            }
        })
        return data
    }

    fun getCity(index: Int) = cityList[index]

    fun getMallName(cityIndex: Int, mallIndex: Int) = cityList[cityIndex].malls[mallIndex].name

    fun getShopsFromMall(cityIndex: Int, mallIndex: Int): List<Shop>? = cityList[cityIndex].malls[mallIndex].shops

    fun getShopsFromCity(index: Int): List<Shop>? {
        val city = cityList[index]
        val shopList = mutableListOf<Shop>()
        city.malls.forEach { mall ->
            mall.shops.forEach {
                shopList.add(it)
            }
        }
        return shopList
    }

    fun getMallsFromCity(index: Int): List<Mall>? {
        val city = cityList[index]
        cityList.forEach {
            if (it == city) {
                return it.malls
            }
        }
        return null
    }
}