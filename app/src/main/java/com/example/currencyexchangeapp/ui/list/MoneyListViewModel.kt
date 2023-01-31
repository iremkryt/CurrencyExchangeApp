package com.example.currencyexchangeapp.ui.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangeapp.di.Resource
import com.example.currencyexchangeapp.domain.usecase.get_moneys.GetMoneysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.lang.Thread.State
import javax.inject.Inject


@HiltViewModel
class MoneyListViewModel @Inject constructor(
    private val getMoneysUseCase: GetMoneysUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MoneyListState())
    val state: androidx.compose.runtime.State<MoneyListState> = _state

    init {
        getMoneys()
    }

    private fun getMoneys() {
        getMoneysUseCase().onEach {  result ->
            when(result){
                is Resource.Success -> {
                    _state.value = MoneyListState(
                        moneys = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = MoneyListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MoneyListState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
