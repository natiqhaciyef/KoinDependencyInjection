package com.natiqhaciyef.koindependencyinjection.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.koindependencyinjection.databinding.RecyclerCryptoItemBinding
import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel
import com.natiqhaciyef.koindependencyinjection.data.network.CryptoService

class CryptoAdapter(
    private val list: List<CryptoModel>
) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    var cryptoOnClick: CryptoBehaviour? = null

    inner class CryptoViewHolder(val binding: RecyclerCryptoItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding =
            RecyclerCryptoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.binding.cryptoPriceTextView.text = "Price: ${list[position].price}"
        holder.binding.cryptoTitleTextView.text = list[position].currency

        holder.itemView.setOnClickListener {
            cryptoOnClick?.onClickCrypto(list[position])
        }
    }
}