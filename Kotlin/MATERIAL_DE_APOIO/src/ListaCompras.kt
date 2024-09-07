import kotlin.concurrent.thread

fun main() {
    val produtos = mutableListOf<String>()

    while (true) {
        println("Bem Vindo! Escolha as seguintes posições")
        println("1 - Adicionar Produtos")
        println("2 - Remover Produtos")
        println("3 - Atualizar Produtos")
        println("4 - Todos")
        println("5 - Sair")
        print("Digite a opção: ")

        val opcaoEscolhida = readln().toInt()

        when(opcaoEscolhida) {
            1 -> {
                print("Digite o nome do produto: ")
                val novoProduto = readln()
                produtos.add(novoProduto)
                println("Produto adicionado!")
            }
            2 -> {
                print("Digite a posição do produto: ")
                val posicao = readln().toInt()
                if (posicao in 0 until produtos.size) {
                    produtos.removeAt(posicao)
                    println("Produto removido!")
                } else {
                    println("Posição inválida!")
                }
            }
            3 -> {
                println("Em manutenção!!")
            }
            4 -> {
                println("Produtos: $produtos")
            }
            5 -> {
                println("Saindo...")
                break
            }
            else -> println("Opção Inválida")
        }

        Thread.sleep(5600)
    }
}
