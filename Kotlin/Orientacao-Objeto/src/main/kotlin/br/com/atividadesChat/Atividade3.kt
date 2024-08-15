package br.com.atividadesChat

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Digite uma palavra: ")

    val palavra = scanner.nextLine()

    val vogais = "aeiouAEIOU"
    var contadorVogais = 0

    for(char in palavra){
        if(char in vogais){
            contadorVogais++
        }
    }

    println("o Número de vogais na palavra é : $contadorVogais")


    }

