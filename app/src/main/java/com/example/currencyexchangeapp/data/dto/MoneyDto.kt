package com.example.currencyexchangeapp.data.dto

import com.example.currencyexchangeapp.domain.model.Money

data class MoneyDto(
    val Alış: String,
    val Değişim: String,
    val Satış: String,
    val Tür: String
)

fun MoneyDto.toMoney(): Money {
    return Money(
        Alış = Alış,
        Değişim = Değişim,
        Satış = Satış,
        Tür = Tür
    )
}