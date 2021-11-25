package com.daffakhairi.portofolio.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffakhairi.portofolio.PortofolioData
import com.daffakhairi.portofolio.R
import com.daffakhairi.portofolio.RVAndroidAdapter
import com.daffakhairi.portofolio.databinding.FragmentAndroidBinding
import kotlinx.android.synthetic.main.fragment_android.*

private const val PORT0FOLIO_LINK = "https://www.dzakyhdr.my.id/"

class AndroidFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding : FragmentAndroidBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAndroidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val androidAdapter = RVAndroidAdapter()
        androidAdapter.setData(PortofolioData.listAppAndroid)

        androidAdapter.onItemClicked = { selectedData ->
            CustomTabsIntent.Builder().build().launchUrl(requireContext(), Uri.parse(selectedData.link))
        }

        with(binding.rvAndroid){
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = androidAdapter
        }

        binding.btnAndroid.text = getString(
            R.string.app_android_btn,
            PortofolioData.listAppAndroid.size.toString()
        )

        binding.txtDocumentasi.setOnClickListener{
            CustomTabsIntent.Builder().build().launchUrl(requireContext(), Uri.parse(PORT0FOLIO_LINK))
        }
    }


}