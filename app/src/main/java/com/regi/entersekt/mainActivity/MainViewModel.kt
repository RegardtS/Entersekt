package com.regi.entersekt.mainActivity

import androidx.lifecycle.*
import com.regi.cityslickersdk.CitySlicker
import com.regi.cityslickersdk.model.City

class MainViewModel : ViewModel() {

    private var cityList : LiveData<List<City>> = CitySlicker.instance.getCityList()
    val cityListLiveData = MediatorLiveData<List<City>>()
    val errorText : LiveData<String> = CitySlicker.instance.getError()

    init {
        cityListLiveData.addSource(cityList) {
            cityListLiveData.value = it
        }
    }

    fun refresh(){
        cityListLiveData.removeSource(cityList)
        cityList = CitySlicker.instance.getCityList()
        cityListLiveData.addSource(cityList) {
            cityListLiveData.value = it
        }
    }
}