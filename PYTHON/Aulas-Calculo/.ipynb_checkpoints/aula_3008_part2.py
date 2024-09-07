"""Tokenizando uma frase (string) e contando as palavras únicas"""

texto = ('Uma das maiores operadoras de linhas de transmissão do país (Taesa) '
         'a empresa tem um nível de endividamento alto '
         'decorrente de grandes investimentos em projetos que começaram do zero '
         'Porém o BBA destaca que a companhia tem perfil de dívida alongado e ' 
         'junto às receitas previsíveis das suas transmissoras ' 
         'tem uma flexibilidade financeira adequada')

contagem_palavras = {}

# conta as ocorrências de cada palavra única
for palavra in texto.split():
    if palavra in contagem_palavras:
        contagem_palavras[palavra] += 1 # atualiza o par chave-valor existente
    else:
        contagem_palavras[palavra] = 1 # insere um novo par de chave-valor

print(f'{"PALAVRA":<15}CONTAGEM')

for palavra, count in sorted(contagem_palavras.items()):
    print(f'{palavra:<15}{count}')

print('\nNúmero de palavras únicas:', len(contagem_palavras))