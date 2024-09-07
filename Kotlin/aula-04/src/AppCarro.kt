fun main() {
    val carro = Carro( // construtor
        "Volvo",
        "XC5",
        ligado = false) // exemplo:
    /*
        é possível reatribuir valores iniciais
         sem se preocupar com a ordem (basta passar o nome)
     */

    println("Estado do carro: ligado: ${carro.ligado}")
    carro.ligar()
    println("Estado do carro: ligado: ${carro.ligado}")

    println("desligando carro...")
    carro.desligar()
    println("Carro ligado? ${carro.ligado}")


    carro.ligar() // ligado = true
    carro.acelerar() // +10
    carro.acelerar() // +10
    carro.acelerar() // +10
    carro.frear() // -10

    println(carro.descricao())


    carro.frear() // -10 velocidaAtual: 10
    carro.frear() // -10 velocidaAtual: 0
    carro.frear() // -10 velocidaAtual: 0
    println("\nVelocidade: ${carro.velocidade}")

    // exemplo do carro desligado (nenhuma velocidade será alterada)
    carro.desligar()
    println(carro.descricao())
    carro.acelerar()
    carro.acelerar()
    println()
    val descricao = carro.descricao()
    println(descricao)


    val acoes = carro.caixaPreta()
    println(acoes)


    carro.exibirVelocidadeComTexto(
        "Esse carro está com ${carro.velocidade} Km/h!!!")

    println(carro.historicoDeAcao)

    // Exemplo para o ex de relógio ------------

    // pegar a hora "1"
    val hora = 1
    // colocar "01" dizendo que %02d
    // (adicionar um 0 a esquerda caso não tenha 2 caracteres)
    println("Hora formatada ${"%02d".format(hora)}")

    // (adicionar um 0 a esquerda caso não tenha 2 caracteres)
    println("Hora formatada ${hora.toString().padStart(2, '0')}")
}