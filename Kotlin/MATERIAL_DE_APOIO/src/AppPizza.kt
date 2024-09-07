fun main() {

    val pizza = PedidoPizza()

    // Solicita e armazena o sabor da pizza
    println("Digite o sabor da pizza: ")
    val sabor: String = readln()
    pizza.sabor = sabor // Atualiza o sabor no objeto pizza

    // Solicita e armazena o preço da pizza
    println("Digite o preço da pizza: ")
    val preco: Double = readln().toDouble()
    pizza.preco = preco // Atualiza o preço no objeto pizza

    // Solicita e armazena a quantidade de amigos
    println("Digite a quantidade de amigos: ")
    val amigos: Int = readln().toInt()
    pizza.quantidadeAmigos = amigos // Atualiza a quantidade de amigos no objeto pizza

    // Solicita e aplica um cupom de desconto
    println("Digite o cupom: ")
    val cupom: String = readln()
    pizza.validarCupom(cupom) // Aplica o cupom de desconto

    // Exibe a descrição do pedido
    println(pizza.descrever())

    // Calcula e exibe o valor que cada amigo deve pagar
    val valorPorAmigo = "%.2f".format(pizza.obterValorPorAmigos())
    println("Cada amigo vai pagar R$$valorPorAmigo")

    // Exibe os cupons que foram usados até o momento
    println(pizza.obterCuponsUsados())
}
