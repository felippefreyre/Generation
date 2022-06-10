package com.generation.todoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.generation.todoapplication.databinding.FragmentFormBinding
import com.generation.todoapplication.databinding.FragmentListBinding

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            //Inflate layout

            binding = FragmentFormBinding.inflate(layoutInflater, container, false)

            binding.buttonSalvar.setOnClickListener{
                findNavController().navigate(R.id.action_formFragment_to_listFragment)
            }

        return binding.root
    }
}