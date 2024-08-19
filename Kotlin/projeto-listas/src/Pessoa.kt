class Pessoa(
    var nome: String,
    var idade : Int
) {
    fun respirar(){
        println("Respirando...")
    }

    fun ola(){
        println("Olá é meu nome é $nome e eu tenho $idade anos")
    }

}