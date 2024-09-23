package org.example

fun main() {
    val estado = Estado()

    estado.setarNome("ba")
    estado.populacao = 7_000_000 //utilização do underline para separa as casas e facilitar a leitura
    estado.uf = "BA"

    println("nome do estado: ${estado.nome}")
    println("população: ${estado.populacao}")
    println("UF: ${estado.uf}")
}