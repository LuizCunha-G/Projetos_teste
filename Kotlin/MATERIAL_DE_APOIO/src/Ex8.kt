package org.example
import java.util.Scanner

fun main() {
    val snSalario = Scanner(System.`in`)

    println("Digite o seu salário:")
    val salario = snSalario.nextDouble()

    when {
        salario >= 0 && salario <= 1000 -> println("Classe C")
        salario > 1000 && salario <= 2000 -> println("Classe B")
        salario > 2000 && salario <= 5000 -> println("Classe A")
        salario > 5000 -> println("Classe AA")
        else -> println("Salário inválido")
    }
}