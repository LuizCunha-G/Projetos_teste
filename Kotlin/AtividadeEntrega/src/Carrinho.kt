class Carrinho {
     var produtos = mutableListOf<Produto>()

    fun adicionarProduto(produto: Produto) {
        produtos.add(produto)
    }

    fun valorTotal(): Double {
        return produtos.sumOf { it.preco }
    }

    fun descreverCarrinho(): String {
        val descricao = produtos.joinToString(separator = "\n") { it.descreverProduto() }
        return """
            Produtos no carrinho:
            $descricao
            Valor total: R$ %.2f
        """.trimIndent().format(valorTotal())
    }
}
