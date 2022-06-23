package com.example.excsqlitecomroom.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.excsqlitecomroom.data.Usuario
import com.example.excsqlitecomroom.databinding.ActivityMainBinding
import com.example.excsqlitecomroom.databinding.UsuarioAdapterBinding

class UsuarioAdapter : RecyclerView.Adapter<UsuarioAdapter.MyViewHolder>() {

    private var listUsuario = emptyList<Usuario>()

    class MyViewHolder(val binding: UsuarioAdapterBinding) : RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(UsuarioAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user = listUsuario[position]

        holder.binding.idAdapter.text = user.id.toString()
        holder.binding.nomeAdapter.text = user.nome
        holder.binding.sobrenomeAdapter.text = user.sobrenome
        holder.binding.idadeAdapter.text = user.idade.toString()

    }

    override fun getItemCount(): Int {

        return listUsuario.size

    }

    fun setList(list: List<Usuario>){

        listUsuario = list
        notifyDataSetChanged()

    }
}
