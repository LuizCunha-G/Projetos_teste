import java.util.Scanner
import kotlin.math.pow

fun main() {

    val soma = 10 + 10
    val subtracao = 10 - 5
    val divisao = 10 / 2
    val multiplicacao = 10 * 2

    // toda vez que tiver alguma operação ou acesso de "atributo"
    println("Soma ${10 + 10}")
    println("Soma $soma")
    println("Subtração $subtracao")
    println("Divisao $divisao")
    println("Multiplicação $multiplicacao")

//    val potencia = 5.0 * 5.0 // tipo "inferido"
//    val potencia = 5.0.pow(2) // funciona também sem declarar
    val potencia: Double = 3.3.pow(2) // tipo "declarativo" do tipo decimal

    // pega a variável e coloca 2 casas decimais ao exibir
    println("Potência ${"%.2f".format(potencia)}")

    val snTexto = Scanner(System.`in`)
    val snNumero = Scanner(System.`in`)

    print("Digite seu nome: ")
    val nome = snTexto.nextLine()

    println("Bem vindo, $nome!")

    print("Digite um número: ")
    val numero = snNumero.nextInt()

    when (numero) {
        1 -> println("É 1")
        2 -> println("É 2")
        3 -> println("É 3")
        in 4..6 -> println("É do número 4 ao 6")
        7, 8, 9 -> println("É 7, 8 ou 9")
        in 10..Int.MAX_VALUE -> println("Exemplo Maior que 10 nesse when")
        else -> println("Número inválido!")
    }

    when {
        numero < 1 -> println("É menor que 1")
        numero == 1 -> println("É 1")
        numero in 4..6 -> println("É do número 4 ao 6")
        numero > 6 -> println("É maior que 6")
    }



}