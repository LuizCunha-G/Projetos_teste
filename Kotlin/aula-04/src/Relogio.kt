class Relogio ( // criando atributos
    var modelo: String = "",
    var preco: Double = 0.0,
    var horas: Int = 0,
    var minutos: Int = 0,
    var segundos: Int = 0
) {

    // zerando todos os atributos
    fun zerar() {
        horas = 0
        minutos = 0
        segundos = 0
    }

    fun validar(): String {
        // inicializando como "valido"
        var valorInvalido = false

        // caso for fora do "range" de 0 a 23
        // zera e atribui valorInvalido = true
        if (horas !in 0..23) {
            horas = 0
            valorInvalido = true
        }
        if (minutos !in 0..60) {
            minutos = 0
            valorInvalido = true
        }
        if (segundos !in 0..60) {
            segundos = 0
            valorInvalido = true
        }

        if (valorInvalido) {
            return "Valores inválidos identificados. Ajustado!" // "break"
        }
        return "Valores corretos!"

//        return if (valorInvalido) "Valores inválidos identificados. Ajustado!" else "Valores corretos!"
    }

    fun verHora(): String {
        validar()

        val horaFormatada = horas.toString().padStart(2, '0') // outro jeito
        val minutoFormatado = "%02d".format(minutos)
        val segundoFormatado = "%02d".format(segundos)

        return "$horaFormatada:$minutoFormatado:$segundoFormatado"
    }
}