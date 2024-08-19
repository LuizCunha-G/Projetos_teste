fun main() {
    val pessoa1 = Pessoa("João", 18)
    val pessoa2 = Pessoa("Maria", 18)

    println("Pessoa 1 - Nome: ${pessoa1.nome} ")
    println("Pessoa 1 - Idade: ${pessoa1.idade} ")

    val pessoas = mutableListOf<Pessoa>()
    pessoas.add(pessoa1)
    pessoas.add(pessoa2)

    for (pessoaDaVez in pessoas) {
        println("A pessoa tem nome ${pessoaDaVez.nome}" + " com idade ${pessoaDaVez.idade}")
    }
    pessoa1.respirar()
    pessoa2.respirar()

    pessoa1.ola()
    pessoa2.ola()

    pessoa1.nome = "Luiz"
    pessoa1.ola()
}

/*
 val nome : String = "João"
    val idade : Int = 18

    val nome1 : String = "Maria"
    val idade1 : Int = 18

    val pessoas = mutableListOf<String>("João", "Maria")
    val idades = mutableListOf<Int>(18,18)
 */