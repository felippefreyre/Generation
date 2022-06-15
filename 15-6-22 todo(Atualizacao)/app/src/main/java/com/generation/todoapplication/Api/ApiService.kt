package com.generation.todoapplication.Api

import com.generation.todoapplication.model.Categoria
import com.generation.todoapplication.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("Categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("tarefa")
    suspend fun addTarefa(
    @Body tarefa: Tarefa
    ) : Response<Tarefa>

}