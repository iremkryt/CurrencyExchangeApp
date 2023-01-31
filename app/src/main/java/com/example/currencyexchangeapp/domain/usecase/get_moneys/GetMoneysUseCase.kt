package com.example.currencyexchangeapp.domain.usecase.get_moneys

import com.example.currencyexchangeapp.data.dto.toMoney
import com.example.currencyexchangeapp.di.Resource
import com.example.currencyexchangeapp.domain.model.Money
import com.example.currencyexchangeapp.domain.repository.MoneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMoneysUseCase @Inject constructor(
    private  val repository: MoneyRepository
) {
    operator fun invoke(): Flow<Resource<List<Money>>> = flow {
        try {
            emit(Resource.Loading())
            val moneys = repository.getMoneys().map { it.toMoney() }
            emit(Resource.Success(moneys))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An expected error occured."))
        } catch (e: IOException){
            emit(Resource.Error("Could not reach server."))
        }
    }
}