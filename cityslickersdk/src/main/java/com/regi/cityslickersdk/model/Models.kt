package com.regi.cityslickersdk.model

data class CitiesApiResponse(
    val cities: List<City>
)

data class City(
    val id: Int,
    val malls: List<Mall>,
    val name: String
)

data class Mall(
    val id: Int,
    val name: String,
    val shops: List<Shop>
)

data class Shop(
    val id: Int,
    val name: String
)