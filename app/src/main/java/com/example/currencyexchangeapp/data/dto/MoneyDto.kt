package com.example.currencyexchangeapp.data.dto

import com.example.currencyexchangeapp.domain.model.Money
import com.google.gson.annotations.SerializedName

data class MoneyDto(
    @SerializedName("alis")
    val alis: String?,
    @SerializedName("degisim")
    val degisim: String,
    @SerializedName("satis")
    val satis: String,
    @SerializedName("tur")
    val tur: String
)

//fun MoneyDto.toMoney(): Money {
//    return Money(
//        Alış = Alış,
//        Değişim = Değişim,
//        Satış = Satış,
//        Tür = Tür
//    )
//}