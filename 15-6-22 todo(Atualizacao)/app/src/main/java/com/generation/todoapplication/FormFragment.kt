package com.generation.todoapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.todoapplication.databinding.FragmentFormBinding
import com.generation.todoapplication.databinding.FragmentListBinding
import com.generation.todoapplication.fragment.DatePickerFragment
import com.generation.todoapplication.fragment.TimerPickerListener
import com.generation.todoapplication.model.Categoria
import com.generation.todoapplication.model.Tarefa
import java.time.LocalDate
import kotlin.math.log

class FormFragment : Fragment(),TimerPickerListener {

    private lateinit var binding: FragmentFormBinding
    private val  mainViewModel: MainViewModel by activityViewModels()
    private var categoriaSelecionada = 0L

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
                inserirtNoBanco()
            }

            binding.editData.setOnClickListener{
                DatePickerFragment(this)
                    .show(parentFragmentManager,"DatePicker")

            }

        return binding.root

    }

    private fun spinnerCategoria(listCategoria: List<Categoria>?){
        if (listCategoria != null){
            binding.spinnerCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listCategoria
                )
            binding.spinnerCategoria.onItemSelectedListener =
             object :AdapterView.OnItemSelectedListener{
                 override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selected = binding.spinnerCategoria.selectedItem as Categoria

                     categoriaSelecionada = selected.id
                 }

                 override fun onNothingSelected(parent: AdapterView<*>?) {
                     TODO("Not yet implemented")
                 }
             }
        }
    }
    private fun validarCampos(
        nome : String, descricao : String, responsavel : String
    ) : Boolean{
        return ! (nome == "" || nome.length < 3 || nome.length <20) ||
                (descricao == "" || descricao.length <5 || descricao.length<200)||
                ( responsavel == "" || responsavel.length <3 || responsavel.length<20
                )
    }

    private fun inserirtNoBanco{
            val nome = binding.editNome.text.toString()
            val desc = binding.editDescricao.text.toString()
            val resp = binding.editResponsavel.text.toString()
            val data = binding.editData.text.toString()
            val status = binding.switchAtivoCard.isChecked
            val categoria = Categoria(categoriaSelecionada,null,null)

            if (validarCampos(nome, desc, resp))
    {
        val tarefa = Tarefa(0, nome, desc, resp, data, status, categoria)
        mainViewModel.addTarefa(terefa)
        Toast.makeText(context, "Tarefa Criada", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_formFragment_to_listFragment)
         }else{
           Toast.makeText(context,"Verifique os Campos",Toast.LENGTH_SHORT).show()
    }


    override fun onDateSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }
}