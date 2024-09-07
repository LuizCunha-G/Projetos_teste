fun main() {
    // a) Configuração Inicial
    val relogio = Relogio(modelo = "Casio", preco = 50.5, hora = 12, minutos = 4, segundos = 8)

    // b) Exibição da Hora
    println("Hora atual: ${relogio.verHora()}")

    // c) Validação Automática
    println(relogio.validar())

    // d) Dados dinâmicos
    val relogio2 = Relogio()

    print("Digite a hora: ")
    relogio2.hora = readLine()?.toIntOrNull() ?: 0

    print("Digite os minutos: ")
    relogio2.minutos = readLine()?.toIntOrNull() ?: 0

    print("Digite os segundos: ")
    relogio2.segundos = readLine()?.toIntOrNull() ?: 0

    // e) Validação e Exibição Final
    println(relogio2.validar())
    println("Hora no 2º relógio: ${relogio2.verHora()}")
}
