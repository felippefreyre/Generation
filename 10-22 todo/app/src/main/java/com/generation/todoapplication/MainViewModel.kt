package com.generation.todoapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todoapplication.Api.Repository
import com.generation.todoapplication.model.Categoria
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {



    val reposiroty = Repository()

    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()


    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    init {
        listCaregoria()
    }

    fun listCaregoria(){
        viewModelScope.launch {
         try {

             val response = reposiroty.listCategoria()
             _myCategoriaResponse.value = response

         }catch (e: Exception){
             Log.d("Erro", e.message.toString())
         }
        }
    }

}