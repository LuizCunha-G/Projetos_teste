import kotlin.concurrent.thread

fun main() {
    val tarefas = mutableListOf<String>()

    while (true) {
        println("Bem Vindo! Escolha as seguintes posições")
        println("1 - Adicionar Tarefa")
        println("2 - Remover Tarefa")
        println("3 - Exibir todas as tarefas")
        println("4 - Atualizar Tarefa")
        println("5 - Exibir número total de tarefas")
        println("6 - Sair")
        print("Digite a opção: ")

        val nomeTarefa = readln().toInt()

        when(nomeTarefa) {
            1 -> {
                print("Digite o nome da tarefa: ")
                val novaTarefa = readln()
                tarefas.add(novaTarefa)
                println("Tarefa adicionada!")
            }
            2 -> {
                print("Digite a posição da tarefa: ")
                val posicao = readln().toInt()
                if (posicao in 0 until tarefas.size) {
                    tarefas.removeAt(posicao)
                    println("Tarefa removido!")
                } else {
                    println("Tarefa inválida!")
                }
            }
            3 -> {
                println("Tarefas: $tarefas")
            }
            4 -> {

                print("Digite o o numero da tarefa: ")
                val novaTarefa = readln().toInt()
                println("Digite o nome da tarefa: ")
                var atualizar = readln()

                if(novaTarefa in 0 until tarefas.size){
                    tarefas[novaTarefa] = atualizar
                    println("Tarefa atualizada")
                }
                else {
                    println("Tarefa não atualizada!")
                }

            }
            5 ->{
                println("Tarefas: ${tarefas.size}")
            }
            6-> {
                println("Saindo...")
                break
            }
            else -> println("Opção Inválida")
        }

        Thread.sleep(5600)
    }
}
