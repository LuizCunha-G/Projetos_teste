package org.example

import java.util.Scanner

fun main() {
    val snNome = Scanner(System.`in`)
    val snBairro = Scanner(System.`in`)

    println("Digite o seu nome: ")

    val nome = snNome.nextLine()

    println("Digite o nome do seu Bairro: ")

    val bairro = snBairro.nextLine()

    println("Você se chama $nome e mora no bairro $bairro")
}