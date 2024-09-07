package org.example

import java.util.Scanner

fun main() {
    val snFrase = Scanner(System.`in`)
    val snVezes = Scanner(System.`in`)

    println("Digite uma frase de pensamento positivo:")
    val frase = snFrase.nextLine()

    println("Quantas vezes você quer repetir a frase?")
    val vezes = snVezes.nextInt()

    for (i in 1..vezes) {
        println("$i: $frase")
    }
}
