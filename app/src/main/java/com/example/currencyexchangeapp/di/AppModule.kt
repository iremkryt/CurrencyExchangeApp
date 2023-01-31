package com.example.currencyexchangeapp.di

import com.example.currencyexchangeapp.data.api.CurrencyApi
import com.example.currencyexchangeapp.data.repository.MoneyRepositoryImpl
import com.example.currencyexchangeapp.domain.repository.MoneyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCurrencyApi(): CurrencyApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMoneyRepository(api: CurrencyApi) : MoneyRepository{
        return MoneyRepositoryImpl(api)
    }
}