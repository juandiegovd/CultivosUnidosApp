package com.sistema.cultivosapp.ui.resources.supplies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sistema.cultivosapp.databinding.FragmentSupplyBinding

class SupplyFragment: Fragment() {

    private var _binding: FragmentSupplyBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  {
        super.onCreate(savedInstanceState)
        _binding = FragmentSupplyBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        return root
    }
}