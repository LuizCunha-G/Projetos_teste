"""Usando um dicionário para representar notas de uma turma"""

planilha_notas = {
    'Julia': [9.2, 8.5, 10.0],
    'Eduardo': [8.3, 9.5, 7.9],
    'Marcio': [9.1, 8.9, 8.2],
    'Reis': [9.7, 9.1, 9.2]
}

total_notas = 0
count_notas = 0

for nome, nota in planilha_notas.items():
    total = sum(nota)
    print(f'A média de {nome} é: {total / len(nota):.2f}')
    total_notas += total
    count_notas += len(nota)

print(f'A média da classe é de: {total_notas / count_notas:.2f}')