package org.example

import com.github.javafaker.Faker


fun main() {
    val faker = Faker()

    println("Digite um número: ")
    val numero = readln().toInt()

    // Debug - adicionando ponto de parada para verificação
    if(numero >= 10){
        println(faker.address().city())
    }

}