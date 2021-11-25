package com.daffakhairi.portofolio.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.daffakhairi.portofolio.PortofolioData
import com.daffakhairi.portofolio.RVAndroidAdapter
import com.daffakhairi.portofolio.RVExperienceAdapter
import com.daffakhairi.portofolio.databinding.FragmentExperienceBinding

class ExperienceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding : FragmentExperienceBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExperienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val AdapterExperience = RVExperienceAdapter()

        AdapterExperience.onItemClicked = { experience ->
            findNavController().navigate(
                ExperienceFragmentDirections.actionExperienceFragmentToExperienceDetailFragment(
                    experience
                )
            )
        }

        AdapterExperience.setData(PortofolioData.listDataExperience)

        with(binding.rvExperience){
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = AdapterExperience
        }
    }
}