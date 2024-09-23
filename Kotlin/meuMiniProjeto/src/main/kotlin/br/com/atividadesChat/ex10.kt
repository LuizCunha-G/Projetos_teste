package kotlin

import java.util.Scanner

fun main() {

    val snNumero = Scanner(System.`in`)

    println("Digite um número: ")

    val numero = snNumero.nextInt()

    val resultado = when {
        numero % 2 == 0 -> "O numero $numero  é par"
        else -> "O número $numero é ímpar"
    }

    println(resultado)
}