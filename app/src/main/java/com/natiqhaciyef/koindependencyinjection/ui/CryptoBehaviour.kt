package com.natiqhaciyef.koindependencyinjection.ui

import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel

interface CryptoBehaviour {
    fun onClickCrypto(cryptoModel: CryptoModel)
}