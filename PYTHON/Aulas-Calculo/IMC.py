## 1. Cálculo de IMC sem detecção de faixa

peso = float(input('Quanto você pesa em Kg? (kg) '))
altura = float(input('Quanto você mede em altura? (m) '))

print()
IMC = peso / (altura ** 2)
print('O seu IMC é de {:.1f}'.format(IMC))

print()
##2. Cálculo IMC com operador and

if IMC < 18.5:
    print('Diagnóstico: Abaixo do peso normal')
elif IMC >= 18.5 and IMC < 25:
    print('Diagnóstico: peso normal')
elif IMC >= 25 and IMC < 30:
    print('Diagnóstico: sobrepeso')
elif IMC >= 30 and IMC < 40:
    print('Diagnóstico: obeso')
elif IMC >= 40:
    print('Diagnóstico: obesidade mórbida')

print()
## 3. Cálculo IMC entre faixas

if IMC < 18.5:
    print('Diagnóstico: Abaixo do peso normal')
elif 18.5 <= IMC < 25:
    print('Diagnóstico: peso normal')
elif 25 <= IMC < 30:
    print('Diagnóstico: sobrepeso')
elif 30 <= IMC < 40:
    print('Diagnóstico: obeso')
elif IMC >= 40:
    print('Diagnóstico: obesidade mórbida')

print()

## 4. Agora altere o código no exercício 1, para que o formato do espaço reservado para o ponto flutuante esteja com 2 casas decimais, O que ocorre com os valores?

print('O seu IMC é de {:.2f}'.format(IMC))


    