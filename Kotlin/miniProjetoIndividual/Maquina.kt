class Maquina(
    var id: String = "",
    var modelo: String = "",
    var cpu: String = "",
    var gpu: String = "",
    var ram: Int = 0,
    var armazenamento: Int = 0,
    var so: String = "",
) {
    fun descrever():String {
        val texto = """
            ID: $id
            modelo: $modelo
            cpu: $cpu
            gpu: $gpu
            ram: ${ram}Gb
            armazenamento: ${armazenamento}Gb
            Sistema Operacional: $so
            ------------------------------------------------------
        """.trimIndent()
        return texto
    }
}