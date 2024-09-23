fun main() {
    var aplicação = true
    var listaUsuario = mutableListOf<Usuario>() // Simulação banco de dados


    while (aplicação) {
        when (gerarLista(
            "Cadastrar Usuário ",
            "Logar Como Usuário ",
            "Sair"
        )) {
            1 -> {
                var email = perguntar("Insira seu email: ")
                var senha = perguntar("Insira sua senha: ")
                var cargo = perguntar(
                    "Insira seu cargo: \n " +
                            "1- Gerente de Operações \n " +
                            "2- Gerente de TI \n " +
                            "3- Suporte de TI \n" +
                            "Sua resposta: "
                ).toInt()
                if (email != "" && senha != "" && cargo in 1.. 3) {
                    if (verificarUs(email, listaUsuario))
                        listaUsuario.add(
                            cadastrarUs(email, senha, cargo)
                        )
                } else
                    println("Insira informações válidas!")
            }

            2 -> {
                var email = perguntar("Insira seu Email:")
                var senha = perguntar("Insira sua Senha:")
                logar(email, senha, listaUsuario)
                Thread.sleep(1000)
            }

            3 -> aplicação = false
        }
    }

}


// Métodos para redução de redundancia
fun gerarLista(texto1: String, texto2: String, texto3: String): Int {
    val lista = listOf(texto1, texto2, texto3)
    for (c in 0..2) {
        println("${c + 1} - ${lista[c]}")
    }
    print("Sua resposta: ")
    val respostaEscolhida = readln().toInt()

    return respostaEscolhida
}

fun perguntar(pergunta: String): String {
    print(pergunta)
    return readln()
}

// Métodos para usuario
fun cadastrarUs(
    email: String,
    senha: String,
    cargo: Int
): Usuario {
    val usuario = Usuario()
    usuario.Email = email
    usuario.Senha = senha
    usuario.Cargo = cargo
    return usuario
}

fun verificarUs(
    email: String,
    lista: MutableList<Usuario>
): Boolean {
    var c = 0

    while (c < lista.size) {
        if (lista[c].Email == email) {
            println("Email já cadastrado!")
            return false
        }
        c++
    }
    return true
}

fun logar(
    email: String,
    senha: String,
    lista: MutableList<Usuario>,
) {
    if (lista.size == 0) {
        println("Nenhum usuário cadastrado")
        return
    }
    var c = 0
    var log = false
    while (c < lista.size) {
        if (lista[c].Email == email && lista[c].Senha == senha) {
            print("Login realizado com sucesso \n")
            lista[c].Logado = true
            Thread.sleep(1000)
            lista[c].validarCargo()
            log = true
        }
        c++
    }
    if (!log) {
        println("Usuário não cadastrado / Senha inválida")
    }

}


//Métodos para

