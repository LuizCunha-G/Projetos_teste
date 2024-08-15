fun main() {
    println("Olá no Kotlin");
    println("Opa!!");

 //   var nome = "Luiz"; var pode ser alterado (mutavel) = equivalente a var no JS
    val nome = "Luiz"; // val não pode ser alterado (imutavel) = equivalente a const no JS
//    var nome : String = "Luiz" (tipo declarativo)

    println("Bom dia " + nome); // concatena
    println("Bom dia $nome");  // interpola
    println("Bom dia ${nome.uppercase()}"); // orienta o objeto

    val salario = 2000
     if(salario < 1500){
         println("Um salário minimo")
     }
    else{
        println("Rico")
     }

    val nota = 6.0
    val resutado = if(nota < 6.0) "Reprovado" else "Aprovado"
    println(resutado);

    if(nota < 3){
        println("deu ruim")
    }
    else if (nota < 6){
        println("Passou Raspando")
    }
    else {
        println("Pode escolher o estágio")
    }

    when(nota){ //swtich case
        1.0 -> println("Deu ruim")
        3.0 -> print("vai levar carcada")
        in 3.0.. 6.0 ->  println("da pra esforçar")
        else -> println("Deu Bom")
    }

    println("-----------------------")
    val nota2 = 2.0


    val resultadonota = when(nota2){
        1.0 -> "Deu ruim"
        3.0 -> "vai levar carcada"
        in 3.0.. 6.0 -> "da pra esforçar"
        else -> "Deu Bom"
    }

    println(resultadonota)
    println("---------------- WHILE")

    var contador = 0

    while (contador < 10){ 
        println("número: ${++contador}") // pré-incremento

        //alternativa
        // contador++
        // println("contador")
    }
    println("---------------------- FOR")

    for(n in 1..10){
        println(n)
    }
}