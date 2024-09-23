import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    val bancoDeDados = mutableListOf<Produto>()

    println("Bem vindo ao gerenciamento de produtos!")

    while (true){

        println("""
            --- Produtos ---
            1 - Adicionar Produto.
            2 - Buscar Produto por indice (comeca de 0).
            3 - Remover produto por indice (comeca de 0).
            4 - Verificar validade por indice (comece de 0).
            5 - Sair.
        """.trimIndent())
        println("Digite a opção desejada")
        val opcao = readln().toInt()

        when(opcao){
            1 -> {
                val novoProduto = Produto()
                println("Digite o nome do produto: ")
                novoProduto.nome = readln()

                println("Digite o preço do novo produto: ")
                novoProduto.preco = readln().toDouble()


                println("Digite a data de validade dd/MM/yyyy: ")
                val dataTexto = readln() // 09/09/2024


                val formatador =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy")

                // parse (texto que chegou, formatador indicado o jeito que veio)
                val dataFormatada = LocalDate.parse(dataTexto, formatador)
                novoProduto.validade = dataFormatada

                bancoDeDados.add(novoProduto)


//
//                println("Digite o ano de vencimento: ")
//                val ano = readln().toInt()
//
//                println("Digite o mês de venciemento: ")
//                val mes = readln().toInt()
//
//                println("Digite o dia do vencimento: ")
//                val dia = readln().toInt()
//
//                novoProduto.validade = LocalDate.of(ano, mes, dia)
            }

            2 ->{
                println("Digite o produto que deseja listar: ")
                val index = readln().toInt()

                if (index > 0 && index <= bancoDeDados.size){

                    val formatador =
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")

                    val produtoEncontrado = bancoDeDados.get(index)
                    println("O Produto ${produtoEncontrado.nome} custa R$ ${produtoEncontrado.preco} tem validade ${produtoEncontrado.validade.format(formatador)}")
                }

                else{
                    println("Produto Não Encontrado")
                }



            }
            3 ->{
                println("Digite o índice do produto para remover: ")
                val index = readln().toInt()

                if (index > 0 && index <= bancoDeDados.size){
                    bancoDeDados.removeAt(index)
                    println("Produto removido com sucesso!")
                }

                else{
                    println("Produto Não Encontrado")
                }
            }

            4 -> {
                println("Digite o índice do produto para verificar a validade: ")
                val index = readln().toInt()

                if(index > 0 && index <= bancoDeDados.size){
                    val produtoEncotrado = bancoDeDados[index]
                    println(produtoEncotrado.descrever())
                }
                else{
                    println("Produto Não Encontrado")
                }


            }

            5 ->
                break
                else -> println("Opção Inválida")

        }
    }
}