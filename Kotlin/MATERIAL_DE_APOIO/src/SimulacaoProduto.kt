fun main() {
    // Registro de Produtos
    val carrinho = Carrinho()

    println("Digite o número de produtos que deseja adicionar ao carrinho: ")
    val numProdutos = readln().toInt()

    for (i in 1..numProdutos) {
        val produto = Produto()

        println("Digite o nome do produto $i: ")
        produto.nome = readln()

        println("Digite o preço do produto $i: ")
        produto.preco = readln().toDouble()

        carrinho.adicionarProduto(produto)
    }

    // Aplicação de Desconto
    println("Digite o percentual de desconto (por exemplo, 0.10 para 10%): ")
    val percentualDesconto = readln().toDouble()
    carrinho.produtos.forEach { it.aplicarDesconto(percentualDesconto) }

    // Exibição do Carrinho
    println(carrinho.descreverCarrinho())
}
