package com.natiqhaciyef.koindependencyinjection.di

import com.natiqhaciyef.koindependencyinjection.data.network.CryptoService
import com.natiqhaciyef.koindependencyinjection.data.repository.CryptoRepository
import com.natiqhaciyef.koindependencyinjection.data.repository.CryptoRepositoryImpl
import com.natiqhaciyef.koindependencyinjection.data.source.CryptoSource
import com.natiqhaciyef.koindependencyinjection.data.usecase.GetAllDataUseCase
import com.natiqhaciyef.koindependencyinjection.ui.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    // singleton scope
    single {
        val BASE_URL = "https://raw.githubusercontent.com/"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(CryptoService::class.java)
    }

    single { CryptoSource(get()) }

    single<CryptoRepository> { CryptoRepositoryImpl(get()) }

    single { GetAllDataUseCase(get()) }

    viewModel { HomeViewModel(get()) }

    // every time re-create instance
//    factory { }
}