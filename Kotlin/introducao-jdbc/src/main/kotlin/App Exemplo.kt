package org.example

//O nome desse conceito no Kotlin é Elvis Operator (?:). Ele é utilizado para fornecer um valor padrão quando uma variável pode ser nula. No seu exemplo:
//O Elvis Operator é muito útil para lidar com valores nulos de maneira concisa.

fun main(){

    var nome : String? = null

    val resposta1: String = nome?: "Nome não definido"
    println(resposta1)

    var resposta2 = ""

    if (nome != null){
        resposta2 = nome
    }
    else{
        resposta2 = "Nome não definido"
    }

    println("Digite seu email: ")
    var email: String = readlnOrNull() ?: "Não Informado"

    println("email: $email")

    println("Digite o número: ")
    var numero: Int = readln().toIntOrNull() ?: 0
    println("Número $numero")


    val musica: Musica? = null
    if (musica != null){
        println("Nome: ${musica.nome}")
        println("Produtor: ${musica.produtor ?: "Sem pordutor"}")
    } else {
        println("Música não existe")
    }


}