fun main() {
    var cofrinho = Cofrinho()

    println("Qual é o objetivo do cofrinho: ")
    cofrinho.objetivo = readln()

    println("Qual é sua meta de valor: ")
    cofrinho.meta = readln().toDouble()

    while (true) {

        println("1 - Depositar no Cofre")
        println("2 - Retirar do cofre")
        println("3 - Detalhes")
        println("4 - Sair")

        var opcaoEscolhida = readln().toInt()

        when(opcaoEscolhida){
            1 ->{
                println("Digite o valor do deposito no cofrinho: ")
                val deposito = readln().toDouble()
                println(cofrinho.depositar(deposito))
            }

            2 ->{
                println("Digite o valor da retirada no cofrinho: ")
                val retirada = readln().toDouble()
                println(cofrinho.retirar(retirada))
            }
            3 ->{
                    println(cofrinho.descrever())
            }
            4 -> {
                println("Saindo...")
                break
            }

            else -> println("Opção Inválida")
        }

    }
}