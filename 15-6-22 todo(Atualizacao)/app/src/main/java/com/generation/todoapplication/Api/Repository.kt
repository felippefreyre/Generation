package com.generation.todoapplication.Api

import com.generation.todoapplication.model.Categoria
import com.generation.todoapplication.model.Tarefa
import retrofit2.Response

class Repository {

    suspend fun  listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }


    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa>{
      return RetrofitInstance.api.addTarefa(tarefa)
    }
}
