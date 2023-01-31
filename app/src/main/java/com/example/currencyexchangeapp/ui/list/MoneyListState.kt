package com.example.currencyexchangeapp.ui.list

import com.example.currencyexchangeapp.domain.model.Money

data class MoneyListState(
    val isLoading: Boolean = false,
    val moneys: List<Money> = emptyList(),
    val error: String = ""
)
