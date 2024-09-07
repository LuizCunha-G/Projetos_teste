class PedidoPizza(
    var sabor: String = "",         // Armazena o sabor da pizza.
    var preco: Double = 0.0,        // Armazena o preço da pizza.
    var quantidadeAmigos: Int = 0   // Armazena a quantidade de amigos que irão dividir a pizza.
) {

    val historicoDeCupons = mutableListOf<String>() // Lista para armazenar os cupons utilizados.

    // Método para descrever o pedido, informando o sabor e o preço formatado.
    fun descrever(): String {
        return "\nPedido de pizza de $sabor, que custa R$%.2f".format(preco)
    }

    // Método para validar um cupom de desconto. Se o cupom for válido, aplica o desconto.
    fun validarCupom(cupom: String): String {
        historicoDeCupons.add(cupom) // Adiciona o cupom ao histórico de cupons.
        if (cupom == "#amopizza") {
            preco = preco * 0.9 // Aplica 10% de desconto se o cupom for "#amopizza".
        }

        return """
            Cupom: $cupom   
        """.trimIndent() // Retorna o código do cupom utilizado.
    }

    // Método para calcular o valor a ser pago por cada amigo, dividindo o preço total pelo número de amigos.
    fun obterValorPorAmigos(): Double {
        return preco / quantidadeAmigos
    }

    // Método para listar todos os cupons utilizados até o momento.
    fun obterCuponsUsados(): String {
        var cuponsUsados = "Cupons usados:\n"
        for (cupomDaVez in historicoDeCupons) {
            cuponsUsados += "- $cupomDaVez\n" // Adiciona cada cupom utilizado à string de cupons usados.
        }
        return cuponsUsados.trim() // Retorna a lista de cupons, removendo espaços extras.
    }
}
