package com.generation.todoapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.todoapplication.databinding.FragmentFormBinding
import com.generation.todoapplication.databinding.FragmentListBinding
import com.generation.todoapplication.fragment.DatePickerFragment
import com.generation.todoapplication.fragment.TimerPickerListener
import com.generation.todoapplication.model.Categoria
import java.time.LocalDate
import kotlin.math.log

class FormFragment : Fragment(),TimerPickerListener {

    private lateinit var binding: FragmentFormBinding
    private val  mainViewModel: MainViewModel by activityViewModels()

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            //Inflate layout

            binding = FragmentFormBinding.inflate(layoutInflater, container, false)

            mainViewModel.listCaregoria()

            mainViewModel.dataSelecionada.value = LocalDate.now()

            mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
               response -> Log.d("Requisicao", response.body().toString())
                spinnerCategoria(response.body())


            }

            mainViewModel.dataSelecionada.observe(viewLifecycleOwner){
               selecteDade -> binding.editData.setText(selecteDade.toString())
            }


            binding.buttonSalvar.setOnClickListener{
                findNavController().navigate(R.id.action_formFragment_to_listFragment)
            }

            binding.editData.setOnClickListener{
                DatePickerFragment(this)
                    .show(parentFragmentManager,"DatePicker")

            }

        return binding.root

    }

    fun spinnerCategoria(listCategoria: List<Categoria>?){
        if (listCategoria != null){
            binding.spinnerCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listCategoria
                )
        }
    }

    override fun onDateSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }
}