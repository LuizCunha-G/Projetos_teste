package br.com.atividadesChat

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Digite o primeiro número: ")
    val numero1 = scanner.nextDouble()

    println("Digite o segundo número: ")
    val numero2 = scanner.nextDouble()

    println("Digite a operação que você deseja (adição +, subtração -, multiplicação *, divisão /): ")
    val operacao = scanner.next()

    val resultado = when (operacao) {
        "adição", "+" -> numero1 + numero2
        "subtração", "-" -> numero1 - numero2
        "multiplicação", "*" -> numero1 * numero2
        "divisão", "/" -> {
            if (numero2 != 0.0) {
                numero1 / numero2
            } else {
                println("Divisão por zero não é permitida.")
                return
            }
        }
        else -> {
            println("Operação inválida.")
            return
        }
    }

    println("O resultado da operação é: $resultado")
}
