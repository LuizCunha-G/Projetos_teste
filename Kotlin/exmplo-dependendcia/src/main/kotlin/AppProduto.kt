package org.example

fun main() {
    var produto = Produto(

    )

    println("Informe o nome do produto: ")
    produto.texto = readln()

    println("Preco do Produto: ")
    produto.preco = readln().toDouble()

    println("É brinde? 1 - É brinde / 2 - Não é brinde")
    var resposta = readln().toInt()

    if(resposta == 1){
        produto.brinde = true
        println("O produto ${produto.texto} custa R$ %.2f".format(produto.preco ))
    }
    else if (resposta == 2){
        produto.brinde = false
        println("O produto ${produto.texto} custa R$ %.2f".format(produto.preco ))
    }

}