fun main() {

    val biblioteca = Livro()  // Cria uma instância da classe Livro

    // Solicita ao usuário as informações do livro
    println("Digite o nome do livro: ")
    biblioteca.titulo = readln()

    println("Digite o nome do autor: ")
    biblioteca.autor = readln()

    println("Digite o preco do livro: ")
    biblioteca.preco = readln().toDouble()

    // Tenta emprestar o livro e informa o usuário se o empréstimo foi bem-sucedido
    if(biblioteca.emprestrarLivro()) {
        println("Livro emprestado com sucesso")
    } else {
        println("O Livro não está disponível para empréstimo")
    }

    // Solicita ao usuário o número de dias de atraso na devolução
    println("Quantos dias de atraso ocorreram: ")
    val atraso = readln().toInt()
    biblioteca.devolverLivro(atraso)  // Devolve o livro e, se houver atraso, exibe a taxa de atraso

    // Exibe as informações do livro após a devolução
    println(biblioteca.descreverLivro())
}