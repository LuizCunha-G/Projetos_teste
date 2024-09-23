import java.time.LocalDate
import java.util.Locale

class Produto(

    var nome : String = "",
    var preco : Double = 0.0,
    var validade: LocalDate = LocalDate.now()
) {

    fun descrever(): String{
        val hoje = LocalDate.now()


        if(validade.isBefore(hoje)){
            return "Da pra mandar pra dentro"
        }
        return  "Produto $nome está vencido!"
    }
}