import java.util.Scanner

fun main() {
    val snString = Scanner(System.`in`)
    val snNumero = Scanner(System.`in`)

    println("Digite seu nome: " )

    val nome = snString.nextLine()

    println("Seu nome é $nome")


    println("Digite sua idade: ")

    val idade = snNumero.nextLine()
    println("$nome sua idade é $idade")

    println("Digite seu email: ")
    val email = snString.nextLine()
    println("Seu email é $email")

    println("Digite sua renda")
    val renda = snNumero.nextDouble()
    println("Sua renda é $renda")
}