package com.example.currencyexchangeapp.data.api

import com.example.currencyexchangeapp.data.dto.MoneyDto
import retrofit2.http.GET

interface CurrencyApi {

    @GET("/today.json")
    suspend fun getMoneys(): List<MoneyDto>
}