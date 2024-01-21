package com.natiqhaciyef.koindependencyinjection.data.repository

import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel
import com.natiqhaciyef.koindependencyinjection.data.source.CryptoSource
import com.natiqhaciyef.koindependencyinjection.util.Resource
import retrofit2.Response

class CryptoRepositoryImpl(
    private val ds: CryptoSource
) : CryptoRepository {

    override suspend fun getAllData(): Response<List<CryptoModel>> = ds.getAllData()
}