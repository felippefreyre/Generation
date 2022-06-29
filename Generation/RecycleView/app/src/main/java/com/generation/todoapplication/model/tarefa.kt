package com.generation.todoapplication.model

data class Tarefa(
    var nome: String,
    var desccricao: String,
    var responsavel: String,
    var data: String,
    var status: Boolean,
    var categoria: String
    ){
}