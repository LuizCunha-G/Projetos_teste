fun main() {
    // Cria uma nova instância da classe ReservaHotel
    val reserva = ReservaHotel()

    // Solicita o nome do hóspede e armazena no objeto reserva
    println("Digite o nome do hospede: ")
    reserva.nomeHospede = readln()

    // Solicita o número do quarto e armazena no objeto reserva
    println("Digite o número do Quarto: ")
    reserva.numeroQuarto = readln().toInt()

    // Solicita o número de noites de estadia e armazena no objeto reserva
    println("Digite quantas noites ele irá passar: ")
    reserva.numeroNoites = readln().toInt()

    // Solicita o preço por noite e armazena no objeto reserva
    println("Digite o preço por noite: ")
    reserva.precoNoites = readln().toDouble()

    // Solicita um código de desconto e aplica, caso seja válido
    println("Digite o código de desconto: ")
    val desconto: String = readln()
    reserva.aplicarDesconto(desconto)

    // Exibe a descrição da reserva
    println(reserva.descrevaReserva())

    // Calcula e exibe o custo total da estadia, formatado com duas casas decimais
    val custoTotal = reserva.calcularCustoTotal()
    println("O custo total da estadia é R$ %.2f".format(custoTotal))
}
