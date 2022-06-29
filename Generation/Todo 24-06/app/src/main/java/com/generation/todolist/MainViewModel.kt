package com.generation.todolist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todolist.api.Repository
import com.generation.todolist.model.Categoria
import com.generation.todolist.model.Tarefa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
        ): ViewModel(){

    var tarefaSeleciona: Tarefa? = null

            //Controle de Categoria

    private var _myCategoriaResponse = MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse


            //Controle de Data
    val dataSelecionada = MutableLiveData<LocalDate>()


            //Controle de Tarefas

    private var _myTarefaResponse = MutableLiveData<Response<List<Tarefa>>>()

    val myTarefaResponse: LiveData<Response<List<Tarefa>>> = _myTarefaResponse

    fun listCategoria() {
        viewModelScope.launch {
            try {
                val response = repository.listCategoria()
                _myCategoriaResponse.value = response
            } catch (e: Exception) {
                Log.d("ErroRequisicao", e.message.toString())
            }
        }

    }

    fun addTarefa(tarefa: Tarefa) { viewModelScope.launch {
            try {
                repository.addTarefa(tarefa)
            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listTarefa(){
        viewModelScope.launch {
            try {
                val response = repository.listTarefa()
                _myTarefaResponse.value = response
            }catch(e:Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }
    fun updateTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            try {
                repository.updateTerafa(tarefa)
                listTarefa()

            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }


    }

    fun deleteTarefa(id: Long){
        viewModelScope.launch {
          try {
              repository.deleteTarefa(id)
              listTarefa()

          }
        }catch (e:Exception){
            Log.d("Erro", e.message.toString())
        }
    }
}