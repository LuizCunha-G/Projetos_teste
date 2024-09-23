fun main() {
    val maquinas = mutableListOf<Maquina>()
    val softwareList = mutableListOf<Software>()

    println("Bem-Vindo ao Sistema Staff Watch!!")
    println("-----------------------------------")
    println("")

    println("Informe os dados do usuário:")
    print("Nome: ")
    val nome = readLine() ?: ""
    print("E-mail: ")
    val email = readLine() ?: ""
    print("Cargo (Suporte de TI, Gerente de TI, Gerente de Operações ou Operador): ")
    val cargo = readLine() ?: ""
    println("Digite sua senha")
    val senha = readLine() ?: ""

    val usuario = Usuario(nome = nome, email = email, cargo = cargo, senha = senha)

    when (cargo) {
        "Gerente de TI", "Suporte de TI" -> menuGerenteTIouSuporte(usuario, maquinas, softwareList)
        "Operador", "Gerente de Operações" -> menuOperadorOuGerenteOperacoes(usuario, maquinas, softwareList)
        else -> println("Cargo não reconhecido.")
    }
}
