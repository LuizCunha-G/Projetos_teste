class ReservaHotel(
    var nomeHospede: String = "",    // Nome do hóspede
    var numeroQuarto: Int = 0,        // Número do quarto reservado
    var numeroNoites: Int = 0,        // Número de noites da reserva
    var precoNoites: Double = 0.0     // Preço por noite de estadia
) {

    val historicoDeCupons = mutableListOf<String>()  // Lista para armazenar os cupons utilizados

    // Método para descrever a reserva com detalhes do hóspede, número de noites e quarto
    fun descrevaReserva(): String {
        return "Reserva de $numeroNoites noites no quarto $numeroQuarto, para o hóspede $nomeHospede"
    }

    // Método para calcular o custo total da estadia (número de noites multiplicado pelo preço por noite)
    fun calcularCustoTotal(): Double {
        return numeroNoites * precoNoites
    }

    // Método para aplicar um desconto, caso o código do desconto seja "#FériasDesconto"
    fun aplicarDesconto(codigoDesconto: String) {
        historicoDeCupons.add(codigoDesconto)  // Adiciona o cupom à lista de cupons usados
        if (codigoDesconto == "#FériasDesconto") {
            precoNoites *= 0.85  // Aplica um desconto de 15% no preço por noite
        }
    }
}
