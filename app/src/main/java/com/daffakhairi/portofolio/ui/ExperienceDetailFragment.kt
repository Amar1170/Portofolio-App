package com.daffakhairi.portofolio.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.daffakhairi.portofolio.databinding.FragmentExperienceDetailBinding


class ExperienceDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding : FragmentExperienceDetailBinding? = null
    private val binding get() = _binding!!
    private val experienceArgs by navArgs<ExperienceDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentExperienceDetailBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            txtTitle.text = experienceArgs.experience.title
            txtSubTitle.text = experienceArgs.experience.detail
            imgDetailProfile.load(experienceArgs.experience.image){
                crossfade(2000)
            }
        }
    }
}