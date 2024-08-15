package org.example

import java.util.Scanner

fun main() {
    val snNome = Scanner(System.`in`)
    val snIdade = Scanner(System.`in`)


    println("Digite seu nome: ")

    val nome = snNome.nextLine()

    println("Digite sua idade: ")

    val idade = snIdade.nextInt()

    val voto = when {
        idade < 16 -> println("$nome, você ainda não pode votar!")
        else -> println("$nome, você Já pode votar!")
    }
}