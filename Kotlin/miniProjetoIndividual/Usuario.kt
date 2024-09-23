import kotlin.concurrent.thread

class Usuario(
    var Email: String = "",
    var Senha: String = "",
    var Cargo: Int = 0,
    var Logado: Boolean = false
) {
    var listaMaquina = mutableListOf<Maquina>() // simulação banco de dados

    var listaOperador = mutableListOf<Operador>() // simulação banco de dados

    fun validarCargo() { // Tela dinâmica de acordo com o cargo
        while (Logado) { //logado é uma variável boolean que server para repetir a função até o usuário deslogar
            when (Cargo) {
                1 -> gerenteop() // função da tela de gerente de operações
                2 -> gerenteti() // função da tela de gerente de TI
                3 -> suporte() // função da tela de suporte de TI

            }
        }
    }

    fun gerenteti() { // tela do gerente de TI
        println("Gerente de TI")
        when (gerarLista("Cadastre uma máquina", "Visualizar máquinas", "Deletar máquina por id")) {
            1 -> {
                cadastrarMaq(
                    perguntar("Insira o modelo da máquina: "),
                    perguntar("Insira o Processador: "),
                    perguntar("Insira a Gpu da máquina: "),
                    perguntar("Insira a quantidade de Ram: ").toInt(),
                    perguntar("Insira o armazenamento da máquina: ").toInt(),
                    perguntar("Insira o sistema operacional da máquina: ")
                )
            }

            2 -> {
                visualizarMaquinas()
                Thread.sleep(2000)
            }

            3 -> {
                visualizarMaquinas()
                val id = perguntar("Insira o ID da máquina que deseja deletar: ").toInt()
                if (id > 0)
                    deletarMaquina(id)
                else
                    println("Insira um id válido")
            }

            4 -> Logado = false
        }
    }

    fun gerenteop() {
        println("Gerente de Operações")
        when (gerarLista(
            "Cadastre um Operador",
            "Visualize os Operadores",
            "Adicionar Atividades Não Permitidas"
        )) {
            1 -> {
                var nome = perguntar("Qual é o nome do Operador?: ")
                var email = perguntar("Qual é o email institucional do operador?: ")
                var maquinaid = perguntar("Qual é máquina que ele está utilizando?(Id da máquina): ")
                var equipe = perguntar("Qual a sua Equipe?: ").toString()
                if (nome != "" && email != "" && maquinaid != "" && equipe != "")
                    if (verificarOp(email, listaOperador)) {
                        println("Cadastro de operador realizado com sucesso!")
                        listaOperador.add(cadastrarOp(nome, email, maquinaid, equipe))
                    } else
                        println("Insira as informações do operador!")
            }

            2 -> visualizarOp()
            3 -> {
                println("Em manutenção")
            }

            4 -> Logado = false
        }
    }

    fun suporte() {
        println("Suporte TI")
        when (gerarLista(
            "Visualizar computador por id",
            "Reportar Incidente",
            "Resolver Incidente"
        )) {
            1 -> {
                println("Em breve...")
            }

            2 -> {
                println("Em breve...")
            }

            3 -> {
                println("Em breve...")
            }
        }


    }

    fun cadastrarMaq(
        Modelo: String,
        Cpu: String,
        Gpu: String,
        Ram: Int,
        Armazenamento: Int,
        So: String
    ) {
        var maquina = Maquina()
        maquina.modelo = Modelo
        maquina.cpu = Cpu
        maquina.gpu = Gpu
        maquina.ram = Ram
        maquina.armazenamento = Armazenamento
        maquina.so = So
        maquina.id = (listaMaquina.size + 1).toString()
        listaMaquina.add(maquina)
        println("Cadastro de máquina realizado com Sucesso!")
    }

    fun visualizarMaquinas() {
        if (listaMaquina.size > 0) {
            println("------------------------------------------------------")
            listaMaquina.forEach() { maquina -> // for específico para listas (for each = para cada)
                val texto = maquina.descrever()
                println(texto)
            }
        } else {
            println("Não foi cadastrada nenhuma máquina")
        }

    }

    fun visualizarOp() {
        if (listaOperador.size > 0) {
            listaOperador.forEach() { operador ->
                println("------------------------------------------------------")
                val texto = operador.descrever()
                println(texto)
            }
        } else {
            println("Não foi cadastrado nenhum operador")
        }
    }

    fun deletarMaquina(Id: Int) {
        var c = 0
        var deletado = false
        while (c in 0..listaMaquina.size - 1) {
            if (c == Id - 1) {
                listaMaquina.removeAt(c)
                println("Máquina removida com sucesso!")
                deletado = true
                break
            }
            c++
        }
        if (!deletado) {
            println("ID não encontrado!")
        }
    }

    fun cadastrarOp(
        Nome: String,
        Email: String,
        MaquinaId: String,
        Equipe: String
    ): Operador {
        var operador = Operador()
        operador.id = (listaOperador.size + 1).toString()
        operador.nome = Nome
        operador.email = Email
        operador.maquinaid = MaquinaId
        operador.equipe = Equipe

        return operador
    }

    fun verificarOp(
        Email: String,
        lista: MutableList<Operador>
    ): Boolean {
        var c = 0

        while (c < lista.size) {
            if (lista[c].email == Email) {
                println("Operador já cadastrado!")
                return false
            }
        }
        return true
    }


}


