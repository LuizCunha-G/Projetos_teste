class Cofrinho(
    var objetivo: String = "",
    var saldo: Double = 0.0,
    var meta: Double = 0.0,
    var depositos: Int = 0
) {

    fun depositar(valorDeposito: Double) {
        if (valorDeposito > 0) {
            saldo += valorDeposito
            depositos++
        }
    }

    fun retirar(valorRetirada: Double) {
        if (valorRetirada > 0 && valorRetirada <= saldo) {
            saldo -= valorRetirada
        }
    }

    fun porcentagemAteMeta(): Double {
        return (saldo / meta) * 100
    }

    fun descrever(): String {
        return if (porcentagemAteMeta() >= 100) {
            "O cofrinho de objetivo $objetivo está com R$ %.2f de saldo. Já chegou na meta, estando em %.2f%% dela!".format(saldo, porcentagemAteMeta())
        } else {
            "O cofrinho de objetivo $objetivo está com R$ %.2f de saldo, estando a %.2f%% da meta de R$ %.2f".format(saldo, porcentagemAteMeta(), meta)
        }
    }
}

/*
Prova de Educação Financeira em Kotlin

Objetivo: Desenvolver um sistema de cofrinho que permite o gerenciamento de metas financeiras.

1. Criação da Classe Cofrinho:

Crie uma classe chamada Cofrinho e dentro da classe, crie os seguintes atributos:
objetivo (tipo: TEXTO): Representa o objetivo financeiro do cofrinho (breve descrição).
saldo (tipo: VALOR REAL, valor padrão: 0.0): O saldo atual do cofrinho começando vazio.
meta (tipo: VALOR REAL, valor padrão: 0.0): A meta financeira do cofrinho (quanto deseja atingir).
depositos (tipo: INTEIRO, valor padrão: 0): Contador para o número de depósitos realizados.

2. Métodos da Classe Cofrinho:

a) Crie o método depositar(valorDeposito: Double) que:

Recebe um valor real valorDeposito como parâmetro.
Sem retorno.
Aumenta o saldo conforme o valorDeposito recebido, apenas se valorDeposito for MAIOR que 0, se não, não faça nada.

b) Crie o método retirar(valorRetirada: Double) que:

Recebe um valor real valorRetirada como parâmetro.
Sem retorno.
Diminui o saldo conforme o valorRetirada recebido, apenas se valorRetirada for MAIOR que 0 e MENOR OU IGUAL que o atributo saldo atual, se não, não faça nada.

c) Crie o método porcentagemAteMeta(): Double que:

Não recebe parâmetros.
Retorna um número real representando a porcentagem do saldo em relação à meta. O cálculo deve ser (saldo / meta) * 100.

d) Crie o método descrever(): String que:

Não recebe parâmetros e retorna uma string.
Retorna uma das seguintes frases após verificação:
Chama o método que verifica a porcentagem da meta e retorna, após isso, verfique se é MAIOR OU IGUAL a 100.
Se a meta ainda não foi alcançada (menor que 100): "O cofrinho de objetivo A está com R$B de saldo, estando a C% da meta de R$D".
Se a meta foi alcançada ou ultrapassada (maior ou igual a 100): "O cofrinho de objetivo A está com R$B de saldo. Já chegou na meta, estando em C% dela!".

3. Implementação da Aplicação

Crie um arquivo Kotlin chamado AppEducacaoFinanceira contendo a função main().

a) Solicite ao usuário o texto do objetivo e o valor da meta (os outros atributos podem ser 0 ou não informados no código)

b) Após criar o cofrinho, crie um loop infinito que exibe um menu igual a esse no console:

------- Cofrinho --------
1 - Depositar no cofre.
2 - Retirar do cofre.
3 - Detalhes.
4 - Sair.

Passo a Passo:

1. Deposita valor ao cofre.
Solicite ao usuário o valor a ser depositado no cofrinho.
Use o valor fornecido no método depositar().
2. Solicite ao usuário o valor a ser retirado do cofrinho.

Solicite ao usuário o valor a ser depositado no cofrinho.
Use o valor fornecido no método retirar() do cofrinho.
3. Exibe a descrição do cofrinho.

Chama o método descrever() e exibe a mensagem no console.
4. Encerre o loop.
*/