fun main() {
    // Registro de Aluno
    val aluno = Aluno()

    println("Digite o nome do aluno: ")
    aluno.nome = readln()

    println("Digite a primeira nota: ")
    aluno.nota1 = readln().toDouble()

    println("Digite a segunda nota: ")
    aluno.nota2 = readln().toDouble()

    println("Digite a terceira nota: ")
    aluno.nota3 = readln().toDouble()

    // Cálculo e Exibição da Média
    val media = aluno.calcularMedia()
    println("A média do aluno ${aluno.nome} é: %.2f".format(media))

    // Verificação de Aprovação
    println("Status de aprovação: ${aluno.verificarAprovacao()}")

    // Atualização das Notas
    println("Digite a nova primeira nota: ")
    val novaNota1 = readln().toDouble()

    println("Digite a nova segunda nota: ")
    val novaNota2 = readln().toDouble()

    println("Digite a nova terceira nota: ")
    val novaNota3 = readln().toDouble()

    aluno.atualizarNotas(novaNota1, novaNota2, novaNota3)

    // Recalcular e exibir nova média e status de aprovação
    println("Após atualização:")
    val novaMedia = aluno.calcularMedia()
    println("A nova média do aluno ${aluno.nome} é: %.2f".format(novaMedia))
    println("Status de aprovação: ${aluno.verificarAprovacao()}")
}
