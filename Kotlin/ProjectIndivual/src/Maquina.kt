class Maquina(
    var id: String,  // Adicionando o ID para identificar a máquina
    var modelo: String,
    var cpu: String,
    var gpu: String,
    var ram: Int,
    var armazenamento: Int,
    var so: String,
    var versaoSO: String,
    var tipoRede: String,
    var usuario: Usuario
) {
    fun descrever() {
        println("Dados do Usuário que cadastrou a máquina:")
        usuario.descrever()
        println("""
            ID: $id
            Modelo: $modelo
            CPU: $cpu
            GPU: $gpu
            RAM: ${ram}GB
            Armazenamento: ${armazenamento}GB
            Sistema Operacional: $so
            Versão do SO: $versaoSO
            Tipo de Rede: $tipoRede
            ------------------------------------------------------
        """.trimIndent())
    }
}