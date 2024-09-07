/*
   caso precise construir um objeto vazio,
   atribua valores a todos os atributos
 */

class Carro(
    var marca: String,
    var modelo: String,
    var velocidade: Int = 0,
    var ligado: Boolean = false
) {

    val historicoDeAcao = mutableListOf<String>()

    fun ligar() {
        ligado = true
        historicoDeAcao.add("Ligou o carro.")
    }

    fun desligar() {
        ligado = false
        historicoDeAcao.add("Desligou o carro.")
    }

    fun acelerar() {
        if (ligado) { // verificando se o carro ta ligado
            velocidade += 10 // somando 10 caso sim

            if (velocidade >= 120) { // se for 120 ou mais
                velocidade = 120 // vira 120
            }

            historicoDeAcao.add("Acelerou o carro.")
        }
    }

    fun frear() {
        if (ligado) {
            velocidade -= 10

            if (velocidade <= 0) {
                velocidade = 0
            }

            historicoDeAcao.add("Freou o carro.")
        }
    }

    fun descricao(): String {
        // maneira alternativa de transformar true (ligado) false (desligado_

//        var textoAlternativo = ""
//        if (ligado) {
//            textoAlternativo = "ligado"
//        } else {
//            textoAlternativo = "desligado"
//        }

        // maneira "simplificada"
        val textoLigado = if (ligado) {
            "ligado"
        } else {
            "desligado"
        }

        return """
            Marca: $marca
            Modelo: $modelo
            Ligado: $textoLigado
            Velocidade: $velocidade
        """.trimIndent()
    }

    fun caixaPreta(): String {
        var acoes = ""
        //      0           1       2           3
        // ["Acelerou", "Freou", "Desligou", "Ligou"]

        // acaoDaVez = "Acelerou" (caso estiver na posição 0)
        for (acaoDaVez in historicoDeAcao) {
            acoes += "\n - $acaoDaVez"
        }

//        // jeito alternativo com index
//        for (index in 1..historicoDeAcao.size) {
//            acoes += "\n - ${historicoDeAcao[index - 1]}"
//        }


        return acoes
    }

    fun exibirVelocidadeComTexto(texto: String) {
        println("Texto Da Velocidade dinâmico: $texto")
    }

}