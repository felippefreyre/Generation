package com.generation.todoapplication.model

data class Categoria (
        var id: Long,
        var descricao: String,
        var Tarefas: List<Tarefa>
        ){

}
