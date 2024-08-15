import java.util.Scanner
import javax.swing.JOptionPane

fun main() {

    // Eu preciso perguntar o nome do usuário e a idade

    // isole a pergunta do nome
    // e retorne o valor que o usuário digitou

    // isole a pergunta da idade
    // e retorne o valor que o usuário digitou

    // isole a mensagem final
    // e exiba: "Olá $nome! Sua idade é $idade"

    // FAÇA DE TAL MANEIRA QUE PERGUNTA
    // 3 VEZES SEM REPETIR CÓDIGO

    for (n in 1..3) {
        var numeracao = when(n) {
            1 -> "primeiro(a)"
            2 -> "segundo(a)"
            3 -> "terceiro(a)"
            else -> "'Fora do range'"
        }

        val nome = perguntaNome("Digite seu ${numeracao}° nome: ")
        val idade = perguntaIdade("Digite sua ${numeracao}ª idade: ")
        mensagem(nome, idade)
    }
}

fun perguntaNome(pergunta: String): String {
    val snTexto = Scanner(System.`in`)
    print(pergunta)
    return snTexto.nextLine()
//    return JOptionPane.showInputDialog(pergunta) // quem quiser "interface"
}

fun perguntaIdade(pergunta: String): Int {
    val snNumero = Scanner(System.`in`)
    print(pergunta)
    return snNumero.nextInt()
//    return JOptionPane.showInputDialog(pergunta).toInt() // quem quiser "interface"
}

fun mensagem(nome: String, idade: Int) {
    println("Olá $nome! Sua idade é $idade")
//    JOptionPane.showMessageDialog(null, "Olá $nome! Sua idade é $idade") // quem quiser "interface"
}