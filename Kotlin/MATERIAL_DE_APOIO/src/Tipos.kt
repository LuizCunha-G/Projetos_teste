fun main() {

    val ConsTexto = "Texto inicial"


    // tipo inferido (tipo é definido pelo valor inicial)
    var texto = "Texto inicial"
    texto = "valor alterado"


    //tipo declarativo (tipo defindo pela delcaração da variável)
    var textoDefinido : String = ""
    //pode ter valor inicial ou não

    // deve conter valor inicial da varável (mesmo com declaração)

    val numero : Int = 10 // pode ter valor inicial ou não (quando é declarativo)
    val real : Double = 10.0 // pode ter valor inicial ou não (quando é declarativo)

    var aposentado : Boolean // pode ter valor inicial ou não (quando é declarativo)

    aposentado = true
    aposentado = false

    println("Aposentado $aposentado")//exibir o print sem dar erro, pois já tem valor

    val aposentadoTexto = aposentado.toString() // converter boolean para string

    val decimalParaInteiro = real.toInt() // converter decimal para int

}