package com.example.currencyexchangeapp.data.repository

import com.example.currencyexchangeapp.data.api.CurrencyApi
import com.example.currencyexchangeapp.data.dto.MoneyDto
import com.example.currencyexchangeapp.domain.repository.MoneyRepository
import javax.inject.Inject

class MoneyRepositoryImpl @Inject constructor(
    private val api: CurrencyApi
) :
    MoneyRepository{
    override suspend fun getMoneys(): List<MoneyDto> {
        return api.getMoneys()
    }

}