fun main() {
    val listaPaises = listOf("Brasil", "Alemanha", "Estados Unidos")
    println("Paises:  $listaPaises")
    println("Primeiro valor: ${listaPaises[0]}")

    var listaProduto = mutableListOf("Bolacha", "Macarrão")
    listaProduto.add("Sabonete")
    listaProduto.add("Detergente")
    listaProduto.remove("Bolacha")
    listaProduto.removeAt(0)

    println("Lista Produto: $listaProduto")

    var listaInteiro = mutableListOf(10, 20)

    var listaINteiroDeclarativo: List<Int> = mutableListOf()
    var listaInteiroDeclarativoSemAlteração: List<Int>

    val listaPessoas = mutableListOf("João", "Maria", "José")
    println("A primeira pessoa ${listaPessoas[0]} $")
    println("A primeira pessoa ${listaPessoas.get(0)}")
    println("A primeira pessoa ${listaPessoas.first()}")
    println("A última pessoa ${listaPessoas.last()}")
    println("A última pessoa ${listaPessoas[listaPessoas.size - 1]}")

    println("O índice existe? ${listaPessoas.indices.contains(4)}")
    println("A pessoa existe? ${listaPessoas.contains("Maria")}")

    if (listaPessoas.indices.contains(4)) {
        println("A quinta pessoa é ${listaPessoas[4]}")
    } else {
        println("Pessoa não existe")
    }

    println("Pessoas: $listaPessoas")
    println("A partir da segunda pessoa ${listaPessoas.drop(1)}")
    println("A partir do penúltimo ${listaPessoas.dropLast(1)}")
    println("Sem o primeiro e o último ${listaPessoas.drop(1).dropLast(1)}")

    listaPessoas.add("Fernando")
    listaPessoas.add("Ezequiel")
    listaPessoas.removeAt(0)
    println("Pessoas $listaPessoas")

    listaPessoas[0] = "Mariazinha"
    listaPessoas.set(0, "Mariazinha")

    val posicaoMaria = listaPessoas.indexOf("Maria")
    println("Posição de Maria: $posicaoMaria")


}
