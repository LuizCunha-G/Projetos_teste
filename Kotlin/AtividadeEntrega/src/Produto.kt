class Produto(
    var nome: String = "",
    var preco: Double = 0.0
) {

    fun aplicarDesconto(percentual: Double) {
        preco *= (1 - percentual)
    }

    fun descreverProduto(): String {
        return "Produto: $nome, Preço: R$ %.2f".format(preco)
    }
}
