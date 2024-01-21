package com.natiqhaciyef.koindependencyinjection.data.source

import com.natiqhaciyef.koindependencyinjection.data.network.CryptoService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoSource(private val service: CryptoService) {

    suspend fun getAllData() = withContext(Dispatchers.IO) {
        service.getData()
    }

}