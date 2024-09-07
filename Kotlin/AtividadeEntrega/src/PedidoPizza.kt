class PedidoPizza(
    var sabor: String = "",
    var preco: Double = 0.0,
    var quantidadeAmigos: Int = 0
) {

    val historicoDeCupons = mutableListOf<String>()

    fun descrever(): String {
        return "\nPedido de pizza de $sabor, que custa R$%.2f".format(preco)
    }

    fun validarCupom(cupom: String): String {
        historicoDeCupons.add(cupom)
        if (cupom == "#amopizza") {
            preco = preco * 0.9 // Aplica 10% de desconto
        }

        return """
            Cupom: $cupom   
        """.trimIndent()
    }

    fun obterValorPorAmigos(): Double {
        return preco / quantidadeAmigos
    }

    fun obterCuponsUsados(): String {
        var cuponsUsados = "Cupons usados:\n"
        for (cupomDaVez in historicoDeCupons) {
            cuponsUsados += "- $cupomDaVez\n"
        }
        return cuponsUsados.trim()
    }
}