package org.example

import java.util.Scanner

fun main() {
    val snOnibus = Scanner(System.`in`)
    val snMenor = Scanner(System.`in`)
    val snMaior = Scanner(System.`in`)

    println("Digite a linha de onibus que você pega: ")

    val onibus = snOnibus.nextLine()

    println("Digite o maior tempo de sua volta: ")

    val maior = snMaior.nextInt()

    println("Digite o menor tempo de sua volta: ")

    val menor = snMenor.nextInt()

    val media = (maior + menor) / 2

    println("A linha $onibus leva em média $media minutos/volta")
}
