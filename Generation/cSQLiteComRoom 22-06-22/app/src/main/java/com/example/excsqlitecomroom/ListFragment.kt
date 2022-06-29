package com.example.excsqlitecomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.excsqlitecomroom.adapter.UsuarioAdapter
import com.example.excsqlitecomroom.databinding.FragmentListBinding

class ListFragment : Fragment(){

    private lateinit var binding : FragmentListBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentListBinding.inflate(layoutInflater, container, false)


        val adapter = UsuarioAdapter()
        binding.recyclerNomes.adapter = adapter
        binding.recyclerNomes.setHasFixedSize(true)
        binding.recyclerNomes.layoutManager = LinearLayoutManager(context)

        mainViewModel.selectUsers.observe(viewLifecycleOwner){

                resposta -> if ( resposta!= null ){
            adapter.setList(resposta)
        }

        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return binding.root

        mainViewModel = ViewModelProvider(this).get( MainViewModel::class.java )

    }



    }

