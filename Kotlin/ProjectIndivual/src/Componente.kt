class Componente(
    var tipo: String,
    var modelo: String,
    var consumoBase: Double // Consumo base em percentual do componente
) {
    fun descrever(): String {
        return "Componente: $tipo - Modelo: $modelo - Consumo Base: $consumoBase%"
    }
}