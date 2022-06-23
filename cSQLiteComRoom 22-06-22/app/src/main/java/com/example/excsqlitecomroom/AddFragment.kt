package com.example.excsqlitecomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.excsqlitecomroom.data.Usuario
import com.example.excsqlitecomroom.databinding.FragmentAddBinding
import com.example.excsqlitecomroom.databinding.FragmentListBinding


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private  val  mainViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(layoutInflater, container, false)


        binding.buttonAdd.setOnClickListener {

          inserirNoBanco()

        }

        return binding.root

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    fun verificarOsCampos(nome : String,  sobrenome: String,  idade : String): Boolean{

        return !( nome == "" || sobrenome == "" || idade == ""   )


    }

    fun inserirNoBanco(){


        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val idade = binding.editIdade.text.toString()

        if ( verificarOsCampos(nome, sobrenome, idade) ){


            val user = Usuario(0, nome, sobrenome, idade.toInt())
            mainViewModel.addUser(user)
            Toast.makeText(context, "Usuario adicionado com sucesso", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{

            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_LONG).show()

        }

    }
}

