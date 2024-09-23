package org.example

import com.github.britooo.looca.api.core.Looca

fun main() {

    val looca = Looca()

    println(looca.sistema)
    println(looca.processador)
    println(looca.memoria)
    println(looca.temperatura)
    println(looca.rede.parametros)
}