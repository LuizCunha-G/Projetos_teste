class Usuario(
    var nome: String,
    var email: String,
    var cargo: String,
    var senha : String
) {
    fun descrever() {
        println(""" 
            Nome: $nome
            E-mail: $email
            Cargo: $cargo
            Senha: $senha
            ------------------------------------------------------
        """.trimIndent())
    }
}