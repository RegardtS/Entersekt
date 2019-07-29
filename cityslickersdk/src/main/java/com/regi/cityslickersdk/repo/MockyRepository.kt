package com.regi.cityslickersdk.repo

import com.regi.cityslickersdk.model.CitiesApiResponse
import com.regi.cityslickersdk.service.MockyService
import retrofit2.Call

class MockyRepository(private val mockyService: MockyService){
    fun getCities(): Call<CitiesApiResponse> {
        return mockyService.getAllCities()
    }
}