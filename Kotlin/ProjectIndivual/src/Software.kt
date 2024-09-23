class Software(
    var nome: String,
    var versao: String,
    var usoCPU: Double,
    var usoGPU: Double,
    var usoRAM: Double,
    var usoRede: Double
) {
    fun descrever() {
        println("""
            Nome do Software: $nome
            Versão: $versao
            Uso de CPU: $usoCPU%
            Uso de GPU: $usoGPU%
            Uso de RAM: $usoRAM%
            Uso de Rede: $usoRede Mbps
            ------------------------------------------------------
        """.trimIndent())
    }
}

fun monitorarUso(softwareList: List<Software>) {
    if (softwareList.isEmpty()) {
        println("Nenhum software cadastrado para monitorar o uso.")
        return
    }

    val usoTotalCPU = softwareList.sumOf { it.usoCPU }
    val usoTotalGPU = softwareList.sumOf { it.usoGPU }
    val usoTotalRAM = softwareList.sumOf { it.usoRAM }
    val usoTotalRede = softwareList.sumOf { it.usoRede }

    val usoMedioCPU = usoTotalCPU / softwareList.size
    val usoMedioGPU = usoTotalGPU / softwareList.size
    val usoMedioRAM = usoTotalRAM / softwareList.size
    val usoMedioRede = usoTotalRede / softwareList.size

    println("""
        Uso total de CPU: $usoTotalCPU%
        Uso total de GPU: $usoTotalGPU%
        Uso total de RAM: $usoTotalRAM%
        Uso total de Rede: $usoTotalRede Mbps

        Média de Uso:
        CPU: $usoMedioCPU%
        GPU: $usoMedioGPU%
        RAM: $usoMedioRAM%
        Rede: $usoMedioRede Mbps
        ------------------------------------------------------
    """.trimIndent())
}

fun menuGerenteTIouSuporte(usuario: Usuario, maquinas: MutableList<Maquina>, softwareList: MutableList<Software>) {
    while (true) {
        println("""
            Escola uma opção:
            1 - Adicionar nova máquina
            2 - Atualizar dados da máquina
            3 - Adicionar novo software
            4 - Atualizar dados do software
            5 - Visualizar dados da máquina
            6 - Visualizar todos os softwares
            7 - Calcular e exibir a média de consumo de todos os softwares
            8 - Cadastrar funcionário em equipe
            9 - Visualizar máquinas por ID ou nome de usuário
            10 - Alterar dados da conta
            11 - Alternar papel de usuário
            12 - Sair
        """.trimIndent())

        when (readLine()?.toIntOrNull()) {
            1 -> {
                // Adicionar nova máquina
                println("Informe os dados da nova máquina:")
                print("ID: ")
                val id = readLine() ?: ""
                print("Modelo: ")
                val modelo = readLine() ?: ""
                print("CPU (Modelo): ")
                val cpu = readLine() ?: ""
                print("GPU (Modelo): ")
                val gpu = readLine() ?: ""
                print("RAM (Quantidade em GB): ")
                val ram = readLine()?.toIntOrNull() ?: 0
                print("Armazenamento (Quantidade em GB): ")
                val armazenamento = readLine()?.toIntOrNull() ?: 0
                print("Sistema Operacional: ")
                val so = readLine() ?: ""
                print("Versão do Sistema Operacional: ")
                val versaoSO = readLine() ?: ""
                print("Rede (Tipo de rede, ex: Wi-Fi 6, Ethernet): ")
                val tipoRede = readLine() ?: ""

                val maquina = Maquina(
                    id = id,
                    modelo = modelo,
                    cpu = cpu,
                    gpu = gpu,
                    ram = ram,
                    armazenamento = armazenamento,
                    so = so,
                    versaoSO = versaoSO,
                    tipoRede = tipoRede,
                    usuario = usuario
                )
                maquinas.add(maquina)
                println("Máquina cadastrada com sucesso!")
            }

            2 -> {
                // Atualizar dados da máquina
                println("Informe o ID da máquina que deseja atualizar:")
                val id = readLine() ?: ""
                val maquina = maquinas.find { it.id == id }
                if (maquina != null) {
                    println("Informe os novos dados da máquina (deixe em branco para manter o valor atual):")
                    print("Modelo [${maquina.modelo}]: ")
                    val modelo = readLine()
                    print("CPU [${maquina.cpu}]: ")
                    val cpu = readLine()
                    print("GPU [${maquina.gpu}]: ")
                    val gpu = readLine()
                    print("RAM [${maquina.ram}GB]: ")
                    val ram = readLine()?.toIntOrNull()
                    print("Armazenamento [${maquina.armazenamento}GB]: ")
                    val armazenamento = readLine()?.toIntOrNull()
                    print("Sistema Operacional [${maquina.so}]: ")
                    val so = readLine()
                    print("Versão do Sistema Operacional [${maquina.versaoSO}]: ")
                    val versaoSO = readLine()
                    print("Rede [${maquina.tipoRede}]: ")
                    val tipoRede = readLine()

                    maquina.modelo = modelo ?: maquina.modelo
                    maquina.cpu = cpu ?: maquina.cpu
                    maquina.gpu = gpu ?: maquina.gpu
                    maquina.ram = ram ?: maquina.ram
                    maquina.armazenamento = armazenamento ?: maquina.armazenamento
                    maquina.so = so ?: maquina.so
                    maquina.versaoSO = versaoSO ?: maquina.versaoSO
                    maquina.tipoRede = tipoRede ?: maquina.tipoRede

                    println("Dados da máquina atualizados com sucesso!")
                } else {
                    println("Máquina não encontrada!")
                }
            }

            3 -> {
                // Adicionar novo software
                println("Informe os dados do novo software:")
                print("Nome do Software: ")
                val nomeSoftware = readLine() ?: ""
                print("Versão do Software: ")
                val versaoSoftware = readLine() ?: ""
                print("Uso de CPU pelo software (%): ")
                val usoCPU = readLine()?.toDoubleOrNull() ?: 0.0
                print("Uso de GPU pelo software (%): ")
                val usoGPU = readLine()?.toDoubleOrNull() ?: 0.0
                print("Uso de RAM pelo software (%): ")
                val usoRAM = readLine()?.toDoubleOrNull() ?: 0.0
                print("Uso de Rede pelo software (em Mbps): ")
                val usoRede = readLine()?.toDoubleOrNull() ?: 0.0

                val software = Software(
                    nome = nomeSoftware,
                    versao = versaoSoftware,
                    usoCPU = usoCPU,
                    usoGPU = usoGPU,
                    usoRAM = usoRAM,
                    usoRede = usoRede
                )
                softwareList.add(software)
                println("Software adicionado com sucesso!")
            }

            4 -> {
                // Atualizar dados do software
                if (softwareList.isEmpty()) {
                    println("Nenhum software cadastrado para atualizar.")
                } else {
                    println("Escolha o software para atualizar:")
                    softwareList.forEachIndexed { index, software ->
                        println("${index + 1} - ${software.nome} (Versão: ${software.versao})")
                    }
                    val index = readLine()?.toIntOrNull()?.minus(1) ?: -1

                    if (index in softwareList.indices) {
                        println("Informe os novos dados do software:")
                        print("Nome do Software: ")
                        val nomeSoftware = readLine() ?: ""
                        print("Versão do Software: ")
                        val versaoSoftware = readLine() ?: ""
                        print("Uso de CPU pelo software (%): ")
                        val usoCPU = readLine()?.toDoubleOrNull() ?: 0.0
                        print("Uso de GPU pelo software (%): ")
                        val usoGPU = readLine()?.toDoubleOrNull() ?: 0.0
                        print("Uso de RAM pelo software (%): ")
                        val usoRAM = readLine()?.toDoubleOrNull() ?: 0.0
                        print("Uso de Rede pelo software (em Mbps): ")
                        val usoRede = readLine()?.toDoubleOrNull() ?: 0.0

                        val software = softwareList[index]
                        software.nome = nomeSoftware
                        software.versao = versaoSoftware
                        software.usoCPU = usoCPU
                        software.usoGPU = usoGPU
                        software.usoRAM = usoRAM
                        software.usoRede = usoRede

                        println("Software atualizado com sucesso!")
                    } else {
                        println("Índice de software inválido!")
                    }
                }
            }

            5 -> {
                // Visualizar dados da máquina
                println("Informe o ID da máquina que deseja visualizar:")
                val id = readLine() ?: ""
                val maquina = maquinas.find { it.id == id }
                if (maquina != null) {
                    maquina.descrever()
                } else {
                    println("Máquina não encontrada!")
                }
            }

            6 -> {
                // Visualizar todos os softwares
                if (softwareList.isEmpty()) {
                    println("Nenhum software cadastrado.")
                } else {
                    softwareList.forEach { software ->
                        software.descrever()
                    }
                }
            }

            7 -> {
                // Calcular e exibir a média de consumo de todos os softwares
                if (softwareList.isEmpty()) {
                    println("Nenhum software cadastrado para calcular a média.")
                } else {
                    monitorarUso(softwareList)
                }
            }

            8 -> {
                // Cadastrar funcionário em equipe
                println("Informe os dados do novo funcionário:")
                print("Nome: ")
                val nomeFuncionario = readLine() ?: ""
                print("E-mail: ")
                val emailFuncionario = readLine() ?: ""
                print("Cargo: ")
                val cargoFuncionario = readLine() ?: ""
                print("Senha: ")
                val senhaFuncionario = readLine() ?: ""


                val funcionario = Usuario(
                    nome = nomeFuncionario,
                    email = emailFuncionario,
                    cargo = cargoFuncionario,
                    senha = senhaFuncionario
                )
                // Supondo que você tenha uma lista de funcionários
                // funcionarios.add(funcionario)  // Adicionar o funcionário à lista
                println("Funcionário cadastrado com sucesso!")
            }

            9 -> {
                // Visualizar máquinas por ID ou nome de usuário
                println("""
                    Escolha uma opção:
                    1 - Visualizar máquinas por ID
                    2 - Visualizar máquinas por nome de usuário
                """.trimIndent())
                when (readLine()?.toIntOrNull()) {
                    1 -> {
                        println("Informe o ID da máquina que deseja visualizar:")
                        val id = readLine() ?: ""
                        val maquina = maquinas.find { it.id == id }
                        if (maquina != null) {
                            maquina.descrever()
                        } else {
                            println("Máquina não encontrada!")
                        }
                    }

                    2 -> {
                        println("Informe o nome do usuário para visualizar as máquinas:")
                        val nomeUsuario = readLine() ?: ""
                        val maquinasUsuario = maquinas.filter { it.usuario.nome == nomeUsuario }
                        if (maquinasUsuario.isNotEmpty()) {
                            maquinasUsuario.forEach { it.descrever() }
                        } else {
                            println("Nenhuma máquina encontrada para o usuário $nomeUsuario.")
                        }
                    }

                    else -> println("Opção inválida.")
                }
            }

            10 -> {
                // Alterar dados da conta
                println("Informe os novos dados da conta (deixe em branco para manter o valor atual):")
                print("Novo nome [${usuario.nome}]: ")
                val novoNome = readLine()
                print("Novo e-mail [${usuario.email}]: ")
                val novoEmail = readLine()
                print("Nova senha: ")
                val novaSenha = readLine()

                if (novoNome?.isNotBlank() == true) usuario.nome = novoNome
                if (novoEmail?.isNotBlank() == true) usuario.email = novoEmail
                if (novaSenha?.isNotBlank() == true) usuario.senha = novaSenha

                println("Dados da conta atualizados com sucesso!")
            }

            11 -> {
                // Alternar papel de usuário
                if (usuario.cargo in listOf("Suporte TI", "Gerente TI")) {
                    println("""
                        Escolha o novo papel:
                        1 - Operador
                        2 - Gerente de Operações
                    """.trimIndent())
                    when (readLine()?.toIntOrNull()) {
                        1 -> {
                            usuario.cargo = "Operador"
                            println("Papel alterado para Operador com sucesso!")
                        }
                        2 -> {
                            usuario.cargo = "Gerente de Operações"
                            println("Papel alterado para Gerente de Operações com sucesso!")
                        }
                        else -> println("Opção inválida.")
                    }
                } else {
                    println("Apenas usuários com papel de Suporte TI ou Gerente TI podem alterar o papel.")
                }
            }

            12 -> {
                // Sair
                println("Saindo...")
                break
            }

            else -> println("Opção inválida.")
        }
    }
}


fun menuOperadorOuGerenteOperacoes(usuario: Usuario, maquinas: MutableList<Maquina>, softwareList: MutableList<Software>) {
    while (true) {
        println("""
            Escolha uma opção:
            1 - Adicionar nova máquina
            2 - Adicionar novo software
            3 - Visualizar dados da máquina
            4 - Visualizar todos os softwares
            5 - Calcular e exibir a média de consumo de todos os softwares
            6 - Sair
        """.trimIndent())

        when (readLine()?.toIntOrNull()) {
            1 -> {
                // Adicionar nova máquina
                println("Informe os dados da nova máquina:")
                print("ID: ")
                val id = readLine() ?: ""
                print("Modelo: ")
                val modelo = readLine() ?: ""
                print("CPU (Modelo): ")
                val cpu = readLine() ?: ""
                print("GPU (Modelo): ")
                val gpu = readLine() ?: ""
                print("RAM (Quantidade em GB): ")
                val ram = readLine()?.toIntOrNull() ?: 0
                print("Armazenamento (Quantidade em GB): ")
                val armazenamento = readLine()?.toIntOrNull() ?: 0
                print("Sistema Operacional: ")
                val so = readLine() ?: ""
                print("Versão do Sistema Operacional: ")
                val versaoSO = readLine() ?: ""
                print("Rede (Tipo de rede, ex: Wi-Fi 6, Ethernet): ")
                val tipoRede = readLine() ?: ""

                val maquina = Maquina(
                    id = id,
                    modelo = modelo,
                    cpu = cpu,
                    gpu = gpu,
                    ram = ram,
                    armazenamento = armazenamento,
                    so = so,
                    versaoSO = versaoSO,
                    tipoRede = tipoRede,
                    usuario = usuario
                )
                maquinas.add(maquina)
                println("Máquina cadastrada com sucesso!")
            }

            2 -> {
                // Adicionar novo software
                println("Informe os dados do software em uso:")
                print("Nome do Software: ")
                val nomeSoftware = readLine() ?: ""
                print("Versão do Software: ")
                val versaoSoftware = readLine() ?: ""
                print("Uso de CPU pelo software (%): ")
                val usoCPU = readLine()?.toDoubleOrNull() ?: 0.0
                print("Uso de GPU pelo software (%): ")
                val usoGPU = readLine()?.toDoubleOrNull() ?: 0.0
                print("Uso de RAM pelo software (%): ")
                val usoRAM = readLine()?.toDoubleOrNull() ?: 0.0
                print("Uso de Rede pelo software (em Mbps): ")
                val usoRede = readLine()?.toDoubleOrNull() ?: 0.0

                val software = Software(
                    nome = nomeSoftware,
                    versao = versaoSoftware,
                    usoCPU = usoCPU,
                    usoGPU = usoGPU,
                    usoRAM = usoRAM,
                    usoRede = usoRede
                )
                softwareList.add(software)
                println("Software adicionado com sucesso!")
            }

            3 -> {
                // Visualizar dados da máquina
                println("Informe o ID da máquina que deseja visualizar:")
                val id = readLine() ?: ""
                val maquina = maquinas.find { it.id == id }
                if (maquina != null) {
                    maquina.descrever()
                } else {
                    println("Máquina não encontrada.")
                }
            }

            4 -> {
                // Visualizar todos os softwares
                if (softwareList.isEmpty()) {
                    println("Nenhum software cadastrado.")
                } else {
                    softwareList.forEach { software ->
                        software.descrever()
                    }
                }
            }

            5 -> {
                // Calcular e exibir a média de consumo de todos os softwares
                if (softwareList.isEmpty()) {
                    println("Nenhum software cadastrado para calcular a média.")
                } else {
                    monitorarUso(softwareList)
                }
            }

            6 -> {
                println("Saindo...")
                return
            }

            else -> {
                println("Opção inválida!")
            }
        }
    }
}

