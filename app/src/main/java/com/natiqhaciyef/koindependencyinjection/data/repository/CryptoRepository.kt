package com.natiqhaciyef.koindependencyinjection.data.repository

import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel
import com.natiqhaciyef.koindependencyinjection.util.Resource
import retrofit2.Response

interface CryptoRepository {

    suspend fun getAllData(): Response<List<CryptoModel>>
}