package com.natiqhaciyef.koindependencyinjection.data.usecase

import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel
import com.natiqhaciyef.koindependencyinjection.data.repository.CryptoRepository
import com.natiqhaciyef.koindependencyinjection.util.Resource

class GetAllDataUseCase(private val repository: CryptoRepository) {

    suspend operator fun invoke(): Resource<List<CryptoModel>> {
        return try {
            val response = repository.getAllData()
            if (response.isSuccessful)
                response.body()?.let {
                    return@let Resource.success(response.body())
                } ?: Resource.error(response.message(), null)
            else
                Resource.error(response.message(), null)
        } catch (e: Exception) {
            Resource.error("Exception: ${e.localizedMessage}", null)
        }
    }

}