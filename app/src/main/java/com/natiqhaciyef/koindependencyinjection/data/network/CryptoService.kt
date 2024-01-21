package com.natiqhaciyef.koindependencyinjection.data.network

import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel
import retrofit2.Response
import retrofit2.http.GET

interface CryptoService {
//    https://raw.githubusercontent.com/

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    suspend fun getData(): Response<List<CryptoModel>>

}