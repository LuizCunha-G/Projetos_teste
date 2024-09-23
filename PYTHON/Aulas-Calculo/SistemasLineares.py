from scipy import stats
import numpy as np
import matplotlib.pyplot as plt


# TESOURO DIRETO

# Dados
tempoVencimento = np.array([18, 5, 11, 9, 14, 6, 13, 8, 22, 15, 7, 20, 19, 16, 21, 10, 17, 12])
rendimento = np.array([2.9, 4.2, 3.2, 3.8, 4.0 , 4.5, 3.4, 3.7, 2.1, 4.7, 4.3, 2.7, 2.5, 4.1, 2.3, 3.5, 3.2, 3.6])

# Regressão linear
solucao = stats.linregress(tempoVencimento, rendimento)
a, b = solucao.slope, solucao.intercept

# Exibindo os coeficientes da equação
print(f"Inclinação (a): {a}, Intercepto (b): {b}")

# Estatísticas
media = np.mean(rendimento)
mediana = np.median(rendimento)
desvio_padrao = np.std(rendimento)

print(f"Média: {media}")
print(f"Mediana: {mediana}")
print(f"Desvio padrão: {desvio_padrao}")

# Função para calcular a reta
def formula(a, b, x):
   return a * x + b

# Função para gerar o gráfico
def graph(a, b):
    x = tempoVencimento
    y = formula(a, b, x)
    plt.scatter(tempoVencimento, rendimento)
    plt.plot(x, y, color='orange')
    plt.xticks(np.arange(5, 25, step=5))  # Ajuste nos ticks do eixo x
    plt.xlabel('Tempo até o vencimento (anos)')
    plt.ylabel('Rendimento (%)')
    plt.title('Rendimento x Tempo até o vencimento (IPCA+2045)')
    plt.grid(True)
    plt.show()

graph(a, b)




## =============================================================
# FOTOGRAFIA

# Velocidade do obturador (s) convertida para decimal
velocidade_obturador = np.array([1/2, 1/4, 1/8, 1/15, 1/30, 1/60, 1/125, 1/250, 1/500, 1/1000])

# Brilho
brilho = np.array([200, 190, 175, 171, 168, 150, 148, 140, 131, 127])

# Regressão linear
solucao = stats.linregress(velocidade_obturador, brilho)
a, b = solucao.slope, solucao.intercept

# Cálculo de medidas estatísticas
moda = stats.mode(brilho)
mediana = np.median(brilho)
decis = np.percentile(brilho, [10, 20, 30, 40, 50, 60, 70, 80, 90])
variancia = np.var(brilho)
desvio_padrao = np.std(brilho)

# Exibindo resultados
print(f"Moda: {moda}")
print(f"Décis: {decis}")
print(f"Mediana: {mediana}")
print(f"Variância: {variancia}")
print(f"Desvio padrão: {desvio_padrao}")

# Função para calcular a reta
def formula(a, b, x):
   return a * x + b

# Função para gerar o gráfico
def graph(a, b):
    x = velocidade_obturador
    y = formula(a, b, x)
    plt.scatter(velocidade_obturador, brilho, label='Dados observados')
    plt.plot(x, y, color='orange', label='Regressão linear')
    plt.xscale('log')  # Usar escala logarítmica para velocidade do obturador
    plt.xlabel('Velocidade do obturador (s)')
    plt.ylabel('Brilho da imagem')
    plt.title('Relação entre Velocidade do Obturador e Brilho')
    plt.grid(True)
    plt.legend()
    plt.show()

graph(a, b)
