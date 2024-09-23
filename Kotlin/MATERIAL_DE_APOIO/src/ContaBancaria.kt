class ContaBancaria(

    var nomeConta : String = "",
    var saldo : Double = 0.0,
    var limite : Double = 0.0,
    var gasto : Double = 0.0

){

    fun adicionarGasto(valorGasto : Double){
        if(saldo - valorGasto >= limite  * -1){
            gasto += valorGasto
            saldo -= valorGasto
        }
        else{
            println("Não é possível adicionar este gasto devido ao limite de crédito.")
        }
    }

    fun depositar(valorDepositar: Double){

        saldo += valorDepositar
    }


    fun verificarLimite(): String {
        if (saldo == limite) {
            return "Cuidado, você está perto do limite!"
        } else if (saldo < (limite * 0.1)) {
            return "Saldo disponível"
        } else {
            // Se nenhuma das condições acima for verdadeira, retornar uma mensagem padrão
            return "Saldo dentro do limite."
        }
    }




}