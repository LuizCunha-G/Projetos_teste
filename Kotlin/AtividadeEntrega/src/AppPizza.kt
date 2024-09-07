fun main() {

    val pizza = PedidoPizza()

    println("Digite o sabor da pizza: ")
    val sabor: String = readln()

    println("Digite o preço da pizza: ")
    val preco: Double = readln().toDouble()

    println("Digite a quantidade de amigos: ")
    val amigos: Int = readln().toInt()

    // Atualiza os valores do objeto pizza
    pizza.preco = preco
    pizza.quantidadeAmigos = amigos

    println("Digite o cupom: ")
    val cupom: String = readln().toString()
    pizza.validarCupom(cupom)

    val precoFormatado = "%.2f".format(pizza.preco)

    // Exibe a descrição do pedido
    println(pizza.descrever())

    // Exibe o valor por amigo
    val valorPorAmigo = "%.2f".format(pizza.obterValorPorAmigos())
    println("Cada amigo vai pagar R$$valorPorAmigo")

    // Exibe os cupons usados
    println(pizza.obterCuponsUsados())
}