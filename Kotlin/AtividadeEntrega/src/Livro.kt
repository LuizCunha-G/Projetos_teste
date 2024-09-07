class Livro(
    var titulo : String = "",   // Título do livro
    var autor : String = "",    // Autor do livro
    var preco : Double = 0.0,   // Preço do livro
    var disponivel : Boolean = true  // Indica se o livro está disponível para empréstimo
) {

    // Método para emprestar o livro. Retorna true se o livro foi emprestado com sucesso, false caso contrário.
    fun emprestrarLivro(): Boolean {
        return if(disponivel) {
            disponivel = false   // Marca o livro como indisponível
            true   // Retorna true indicando que o empréstimo foi realizado
        } else {
            false  // Retorna false indicando que o livro já estava emprestado
        }
    }

    // Método para devolver o livro. Recebe como parâmetro o número de dias de atraso.
    fun devolverLivro(diasAtraso: Int) {
        // Se houve atraso na devolução, calcula e exibe a taxa de atraso.
        if(diasAtraso > 0) {
            val taxa = preco * 0.05 * diasAtraso  // Calcula a taxa de atraso (5% do preço por dia de atraso)
            println("Taxa de atraso: R$ %.2f".format(taxa))  // Exibe a taxa de atraso
        }
        disponivel = true  // Marca o livro como disponível novamente
    }

    // Método que retorna uma descrição do livro, incluindo o título, autor e preço formatado.
    fun descreverLivro(): String {
        return "Livro: $titulo, Autor $autor, Preço:R$ %.2f".format(preco)
    }

}
