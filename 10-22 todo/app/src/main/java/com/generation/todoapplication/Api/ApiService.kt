package com.generation.todoapplication.Api

import com.generation.todoapplication.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("Categoria")
    suspend fun listCategoria(): Response<List<Categoria>>
}