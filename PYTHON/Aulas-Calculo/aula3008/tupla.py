## TUPLA
"""
 uma tupla é uma sequêcia imutável e de tamanho fixo de objetos python que de uma vez atrvibuida, Não pode ser alterada. A maneira mais fácil de criar uma tupla é com uma sequência de valores separados por virgula e inseridos em parênteses.

"""

tup = (4, 5, 6)

"""
Podemos converter qualuqer sequência ou iterador em uma tupla chamando "tuple"
"""
tuple([4,0,2])


tup = (4,5,6)
print(tup, type(tup))

tuple ([4,0,2])

tuple('String')

"""
Na definição de tuplas dentro de expressões mais complicadas, geralmente é necessário inserir os valores em parênteses, como na criação de uma tupla.
"""

print()
nested_tup = ((4,5,6), (7,8))

print(nested_tup)
print(nested_tup[0])
print(nested_tup[1])

## CONCATENAÇÃO DE TUPLAS

"""
Você pode usar o operador "+" para produzir tuplas maiores
"""

print()
tup = ('foo', [1,2,3], True)
a = (6,0)
b = ('bar',)

print(tup + a + b)

##  DESEMPACOTAMENTO DE TUPLAS 
# Se você tentar fazer uma atrbuição a uma expressão de variáveis o tipos, python tentrá desmpacotar o claor do lado direito do sinal de igualdade

print()
tup = (4,5,6)
a, b, c = tup 
print(b)

# Um uso comum do desempacotamento de variáveis é na iteração por sequências de tuplas ou listas

print()
seq = [(1,2,3), (4,5,6), (7,8,9)]

for a, b, c in seq:
    print(f'a={a}, b={b}, c={c}')


#Podem ocorrer situações nas quais você extrair alguns elementos do inicio de uma tuplas. Há uma sintaxe especial qua faz isso, "*rest", que também usada em asssinatura de funções para capturar de uma lista arbitariamente longa de argumentos posicionais

#A parcela referente a "rest" poderia ser algo que você quisesse descartar; não há nada de especial no nome "rest". POr uma Questão de convenção muitas vezes é utilizado o underscore "_" para variáveis indesejadas

print()
values = (1,2,3,4,5,6)

a, b, *rest = values

print(a)
print(b)
print(rest)

print()
values = ('olá', 'mundo', 'python', 'java', 'mysql', 'oracle')
c, d, *_ = values

_
print(c)
print(d)
print(_)