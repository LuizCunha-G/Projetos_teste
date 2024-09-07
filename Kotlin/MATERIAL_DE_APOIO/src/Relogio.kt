/*
Relógios Inteligentes
Você foi contratado por uma renomada empresa de tecnologia para desenvolver um protótipo de relógio inteligente em Kotlin. Este relógio, além de ter as funções tradicionais, deverá ter a capacidade de ajustar automaticamente a hora e alertar o usuário sobre possíveis erros nos ajustes manuais.



1. Criação da Classe "Relogio":
Como parte do desenvolvimento, você deve criar uma classe chamada Relogio com as seguintes características:



a) Atributos:

modelo (tipo: TEXTO, valor padrão de ""): O nome do modelo do relógio.
preco (tipo: VALOR REAL, valor padrão de 0.0): O preço do relógio em reais.
horas (tipo: INTEIRO, valor padrão de 0): A hora atual configurada no relógio.
minutos (tipo: INTEIRO, valor padrão de 0): Os minutos atuaisl configurado no relógio.
segundos (tipo: INTEIRO, valor padrão de 0): Os segundos atuais configurado no relógio.

b) Métodos:

zerar(): SEM PARÂMETRO e SEM RETORNO. Um método que, ao ser acionado, redefine os valores de horas, minutos e segundos para 0. Ideal para quando o usuário deseja iniciar a contagem do tempo do zero ou algum outro tipo de validação.

validar(): SEM PARÂMETRO e COM RETORNO TEXTO. Este método verifica se os valores configurados de horas, minutos e segundos estão dentro dos intervalos válidos. Se algum valor estiver fora desses limites, o relógio ajustará automaticamente os valores para 0 os valores que não estiverem dentro do permitido. ex:

horas: entre 0 e 23.
minutos: entre 0 e 60.
segundos: entre 0 e 60.
Caso qualquer um desses estiver fora, já se enquadra em número inválido. Ao passar por todos os atributos que necessitam de validação, o método deve retornar uma mensagem informando se ajustes foram necessários ("Valores inválidos identificados. Ajustado!") ou se todos os valores estavam corretos ("Valores corretos!").

verHora(): SEM PARÂMETRO e COM RETORNO TEXTO. Um método que exibe a hora atual no formato HH:MM:SS (caso for 0 até 9 ,exiba o 0 a esquerda tornando "01" e etc). Antes de retornar a hora, o relógio deve realizar a validação que já foi criada anteriormente, garantindo que a hora exibida seja sempre correta.

2. Simulação de Uso:
Para demonstrar as capacidades do relógio, crie um arquivo Kotlin chamado SimulacaoRelogio. Neste arquivo, implemente uma função main() que simule as seguintes interações:


a) Configuração Inicial: Crie um objeto da classe Relogio com um modelo, preço, hora, minutos e segundos definidos.

b) Exibição da Hora: Utilize a saída do terminal para exibir a hora atual configurada no relógio, utilizando o método verHora() e exiba no terminal o resultado dele.
c) Validação Automática: Verifique se a hora configurada é válida e exiba o resultado da validação na saída do terminal.

d) Dados dinâmicos:  Crie uma instância do Relogio chamada relogio2 e sem dados iniciais, pergunte ao usuário os valores que deseja inserir e atribua os valores no objeto instânciado em seus respectivos atributos.

e) Validação e Exibição Final: Após o usuário configurar o segundo relógio, valide os valores inseridos e exiba o resultado da validação. Em seguida, exiba a frase "Hora no 2º relógio: X", onde X representa o método de exibição de hora da classe.
 */

class Relogio(
    var modelo: String = "",
    var preco: Double = 0.0,
    var hora: Int = 0,
    var minutos: Int = 0,
    var segundos: Int = 0
) {

    fun zerar() {
        hora = 0
        minutos = 0
        segundos = 0
    }

    fun validar(): String {
        var ajustesFeitos = false

        if (hora !in 0..23) {
            hora = 0
            ajustesFeitos = true
        }

        if (minutos !in 0..59) {
            minutos = 0
            ajustesFeitos = true
        }

        if (segundos !in 0..59) {
            segundos = 0
            ajustesFeitos = true
        }

        return if (ajustesFeitos) {
            "Valores inválidos identificados. Ajustado!"
        } else {
            "Valores corretos!"
        }
    }

    fun verHora(): String {
        validar()
        return String.format("%02d:%02d:%02d", hora, minutos, segundos)
    }
}
