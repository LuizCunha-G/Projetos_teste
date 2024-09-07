package org.example

import java.util.Scanner

fun main() {

    val snNome = Scanner(System.`in`)
    val snAltura = Scanner(System.`in`)

    println("Digite o seu nome: ")

    val nome = snNome.nextLine()

    println("Digite a sua altura em metros: ")

    val altura = snAltura.nextDouble()

    val resultado = when {
        altura >= 1.8 -> "você pode jogar basquete"
        else -> "você não pode jogar basquete"
    }

    println("$nome, $resultado")
}