package org.example

import java.util.Scanner

fun main() {

    val nome = perguntaNome("Digite seu nome: ")
    val altura = perguntaAltura("Digite sua altura em metros: ")
    val peso = perguntaPeso("Digite seu peso em quilogramas: ")

    val imcValor = calcularIMC(peso, altura)

    mensagem(nome, imcValor)
}

fun perguntaNome(pergunta: String): String {
    val snTexto = Scanner(System.`in`)

    println(pergunta)

    return snTexto.nextLine()
}

fun perguntaAltura(pergunta: String): Double {
    val snDouble = Scanner(System.`in`)
    var altura: Double

    do {
        println(pergunta)
        altura = snDouble.nextDouble()
        when {
            altura <= 0 -> println("Altura inválida! Digite um valor positivo.")
        }
    } while (altura <= 0)

    return altura
}

fun perguntaPeso(pergunta: String): Double {
    val snDouble = Scanner(System.`in`)
    var peso: Double

    do {
        println(pergunta)
        peso = snDouble.nextDouble()
        when {
            peso <= 0 -> println("Peso inválido! Digite um valor positivo.")
        }
    } while (peso <= 0)

    return peso
}

fun calcularIMC(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

fun mensagem(nome: String, imc: Double) {
    val imcFormatado = "%.2f".format(imc)
    val categoria = when {
        imc < 18.5 -> "abaixo do peso"
        imc in 18.5..24.9 -> "peso normal"
        imc in 25.0..29.9 -> "sobrepeso"
        imc in 30.0..34.9 -> "obesidade grau 1"
        imc in 35.0..39.9 -> "obesidade grau 2"
        else -> "obesidade grau 3"
    }

    println("$nome, seu IMC é de: $imcFormatado, que indica $categoria.")
}
