package com.generation.todolist.api

import com.generation.todolist.model.Categoria
import com.generation.todolist.model.Tarefa
import retrofit2.Response
import java.time.ZoneId

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.addTarefa(tarefa)
    }

    suspend fun listTarefa(): Response<List<Tarefa>> {
        return RetrofitInstance.api.listTarefa()
    }
    suspend fun updateTerafa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitInstance.api.updateTarefa(tarefa)
    }

    suspend fun deleteTarefa(id:Long) : Response<Tarefa>{
        return RetrofitInstance.api.deleteTarefa(id)
    }


}