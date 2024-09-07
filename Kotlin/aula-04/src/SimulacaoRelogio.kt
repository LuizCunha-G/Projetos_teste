fun main() {

    val relogio1 = Relogio(
        "Rolex",
        2000.0,
        70, // valor inválido
        10,
        15)

    println(relogio1.validar())
    println(relogio1.verHora())

    val relogio2 = Relogio()

    print("Qual é o modelo: ")
    relogio2.modelo = readln()

    print("Qual é o preço: ")
    relogio2.preco = readln().toDouble()

    print("Qual é a hora: ")
    relogio2.horas = readln().toInt()

    print("Quais são os minutos: ")
    relogio2.minutos = readln().toInt()

    print("Quais são os segundos: ")
    relogio2.segundos = readln().toInt()

    println(relogio2.validar())
    println(relogio2.verHora())

    relogio2.zerar()
    println(relogio2.verHora())

}