class Aluno(
    var nome: String = "",
    var nota1: Double = 0.0,
    var nota2: Double = 0.0,
    var nota3: Double = 0.0
) {

    fun calcularMedia(): Double {
        return (nota1 + nota2 + nota3) / 3
    }

    fun verificarAprovacao(): String {
        return if (calcularMedia() >= 6.0) "Aprovado" else "Reprovado"
    }

    fun atualizarNotas(n1: Double, n2: Double, n3: Double) {
        nota1 = n1
        nota2 = n2
        nota3 = n3
    }
}