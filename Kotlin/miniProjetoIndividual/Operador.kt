class Operador(
    var id:String = "",
    var nome:String = "",
    var email: String = "",
    var maquinaid:String = "",
    var equipe: String= ""
    ) {
    fun descrever():String{
        val texto = """
            Id do operador: $id
            Nome do operador: $nome
            Email do operador: $email
            Id da máquina do operador: $maquinaid
            Equipe do operador: $equipe
            ------------------------------------------------------
        """.trimIndent()
        return texto
    }
}