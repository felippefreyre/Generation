package com.generation.todoapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.todoapplication.Adapter.TarefaAdapter
import com.generation.todoapplication.databinding.FragmentListBinding
import com.generation.todoapplication.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Inflate layout

        binding = FragmentListBinding.inflate(layoutInflater, container, false)


        val view = inflater.inflate(R.layout.fragment_list, container, false)

        var listTarefas = listOf(
            Tarefa(
                "Lavar a louça",
                "Do almoço a da janta",
                "Matheus",
                "07/06/2022",
                false,
                "Dia a dia"
            ),
            Tarefa(
                "Lazer",
                "Ver kong fu Panda 2",
                "Matheus",
                "08/06/2022",
                false,
                "Lazer"
            ),
            Tarefa(
                "Acompanhar Mômô",
                "Mômô vai fazer a unha e eu quero acompanhar",
                "Matheus",
                "11/06/2022",
                false,
                "Mômô"
            )
        )

        //Configuração do RecycleView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefas)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}