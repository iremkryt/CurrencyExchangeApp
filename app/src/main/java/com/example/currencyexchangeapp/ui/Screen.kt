package com.example.currencyexchangeapp.ui

sealed class Screen(val route: String) {
    object MoneyListScreen: Screen("money_list_screen")
}
