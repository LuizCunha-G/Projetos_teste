## Exercicios Aula Calculo
## 23/08/24
## Luiz Gustavo Dantas
## R.A: 03241060 

# Lista de cálculos
calculos = [
    2**3,
    (-2)**3,
    1**1,
    (-1)**0,
    2**0,
    (2/5)**3,
    3**(-2),
    (2/1)**(-3),
    ((-2)**3)**4,
    0.5**3,
    0.25**4,
    0**4,
    1 + (0.41)**2,
    (1 / 4) + 5**2 - 2**(-4),
    2**(-3) + (-4)**(-5),
    (((4/5) - (1/2) + 1)**-2) + (1 / (1 + 3**2 - (4-5)**-2))
]

# Contador inicial
i = 1

# Estrutura de repetição while
while i <= len(calculos):
    print(f"Exercicio {i}:", calculos[i-1])
    i += 1
