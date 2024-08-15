package org.example

import kotlin.math.pow
import java.util.Scanner

fun main() {
    val snNome = Scanner(System.`in`)
    val snPeso = Scanner(System.`in`)
    val snAltura = Scanner(System.`in`)

    print("Digite seu nome:")
    val nome = snNome.nextLine()

    print("Digite seu peso:")
    val peso = snPeso.nextInt()

    print("Digite sua altura:")
    val altura = snAltura.nextDouble()

    val imc = peso / altura.pow(2)

    println ("Olá $nome! Seu IMC é de ${"%.2f".format(imc)}")

}