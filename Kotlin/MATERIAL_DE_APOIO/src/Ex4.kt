package org.example

import java.util.Scanner

fun main() {
    val snNome = Scanner(System.`in`)
    val snGol = Scanner(System.`in`)

    println("Digite o nome do atacante: ")

    val nome = snNome.nextLine()

    println("Digite o número de Gols que ele marcou: ")

    val gols = snGol.nextInt()

    val resultado = when {
        gols > 5 -> "Artilheiro"
        gols in 3 .. 5 -> "Dá pro gasto"
        gols in 1 .. 2 -> "Pontaria meia boca"
        else -> "Sem pontaria"
    }

    println("$resultado esse $nome")

}