package com.example.currencyexchangeapp.domain.repository

import com.example.currencyexchangeapp.data.dto.MoneyDto

interface MoneyRepository {

    suspend fun getMoneys(): List<MoneyDto>
}