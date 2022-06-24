package com.generation.todolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.todolist.adapter.TarefaAdapter
import com.generation.todolist.adapter.TaskClickListener
import com.generation.todolist.databinding.FragmentListBinding
import com.generation.todolist.model.Tarefa

class ListFragment : Fragment(),TaskClickListener {

    private lateinit var binding: FragmentListBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)


        //Configurando RecyclerView
        val adapter = TarefaAdapter(this,mainViewModel)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener {
            mainViewModel.tarefaSeleciona = null
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        //Requisição de Tarefas
        mainViewModel.listTarefa()
        mainViewModel.myTarefaResponse.observe(viewLifecycleOwner){
                response -> if(response.body() != null){
            adapter.setList(response.body()!!)
            }
        }
        return binding.root
    }

    override fun onToskClicklListener(tarefa: Tarefa) {
        mainViewModel.tarefaSeleciona = tarefa
        findNavController().navigate(R.id.action_listFragment_to_formFragment)

    }

}