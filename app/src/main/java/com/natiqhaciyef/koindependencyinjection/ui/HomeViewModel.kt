package com.natiqhaciyef.koindependencyinjection.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel
import com.natiqhaciyef.koindependencyinjection.data.network.CryptoService
import com.natiqhaciyef.koindependencyinjection.data.usecase.GetAllDataUseCase
import com.natiqhaciyef.koindependencyinjection.util.Status
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val getAllDataUseCase: GetAllDataUseCase
) : ViewModel(), CoroutineScope {
    val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    private var _cryptoLiveData = MutableLiveData<List<CryptoModel>>()
    val cryptoLiveData: MutableLiveData<List<CryptoModel>>
        get() = _cryptoLiveData

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val result = getAllDataUseCase.invoke()
            when (result.status) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    result.data?.let {
                        _cryptoLiveData.value = it
                    }
                }

                Status.ERROR -> {}
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}