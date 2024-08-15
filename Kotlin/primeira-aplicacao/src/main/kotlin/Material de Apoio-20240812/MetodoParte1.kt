import java.util.Scanner

fun main() {

    val nome = pergunta("Digite o primeiro nome: ")
    val nome2 = pergunta("Digite o segundo nome: ")

    exibeMensagemFinal(arg1 = nome, arg2 = nome2)
    exibeMensagemFinal(nome, nome2)
}

fun pergunta(texto: String): String {
    val snTexto = Scanner(System.`in`)

    print(texto)

    // jeito 1 = guardando em uma variável xpto e devolvendo o valor pra quem chamou
//    val nome: String = snTexto.nextLine()
//    return nome

    // jeito 2 = pegando o que o usuário digitou e devolvendo o valor pra quem chamou
    return snTexto.nextLine()
}

fun exibeMensagemFinal(arg1: String, arg2: String) {
    println("Bem vindo, $arg1 e $arg2!")
}