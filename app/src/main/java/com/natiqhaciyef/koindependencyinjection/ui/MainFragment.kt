package com.natiqhaciyef.koindependencyinjection.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.koindependencyinjection.databinding.FragmentMainBinding
import com.natiqhaciyef.koindependencyinjection.data.model.CryptoModel
import com.natiqhaciyef.koindependencyinjection.data.network.CryptoService
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope


class MainFragment : Fragment(), AndroidScopeComponent {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CryptoAdapter
    override val scope: Scope by fragmentScope()
    private val hello by inject<String>(qualifier = named("hello"))       // injected string "Hello world!"
    private val koin by inject<String>(qualifier = named("koin"))       // injected string "Koin, injected!"


    // koin field injection
    private val viewModel by viewModel<HomeViewModel>()
//    private val service = get<CryptoService>()
//    private val serviceLazy by inject<CryptoService>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cryptoLiveData.observe(viewLifecycleOwner) {
            adapter = CryptoAdapter(it)
            binding.recyclerCryptoView.adapter = adapter
            adapter.cryptoOnClick = object : CryptoBehaviour {
                override fun onClickCrypto(cryptoModel: CryptoModel) {
                    Toast.makeText(
                        requireContext(),
                        "${cryptoModel.currency} selected",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            binding.recyclerCryptoView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            println(hello)
            println(koin)
        }

    }
}