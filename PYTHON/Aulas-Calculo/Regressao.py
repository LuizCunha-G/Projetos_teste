import numpy as np
import matplotlib.pyplot as plt
from scipy import stats

# Dados
x = [36, 82, 45, 49, 21, 24, 58, 73, 85, 52]  # Quantidade de conservante (gramas)
y = [6, 14, 5, 13, 5, 8, 14, 11, 18, 6]       # Medição de hiperatividade

# 1. Gráfico de dispersão
plt.scatter(x, y)
plt.xlabel('Quantidade de conservante (g)')
plt.ylabel('Medição de hiperatividade')
plt.title('Dispersão: Quantidade de Conservante x Hiperatividade')
plt.grid(True)
plt.show()

# 2. Regressão linear
solucao = stats.linregress(x, y)
a, b = solucao.slope, solucao.intercept

print(f"Equação da reta: y = {a:.4f}x + {b:.4f}")

# Função para calcular a reta
def formula(a, b, c):
   return a * c + b

# Função para gerar o gráfico com a linha de regressão
def graph(a, b):
    a1 = np.array(x)
    a2 = formula(a, b, a1)
    plt.scatter(x, y, label='Dados Originais')
    plt.plot(a1, a2, color='orange', label=f'Reta de regressão: y = {a:.4f}x + {b:.4f}')
    plt.xlabel('Quantidade de conservante (g)')
    plt.ylabel('Medição de hiperatividade')
    plt.title('Regressão Linear: Conservante x Hiperatividade')
    plt.legend()
    plt.grid(True)
    plt.show()

graph(a, b)

# 3. Estimativa de hiperatividade para 65 gramas de conservante
quantidade_conservante = 65
estimativa_hiperatividade = formula(a, b, quantidade_conservante)
print(f"Estimativa de hiperatividade para 65g de conservante: {estimativa_hiperatividade:.2f}")

# 4. Discussão dos resultados:
# - A reta de regressão parece descrever de maneira razoável o comportamento geral dos dados.
# - No entanto, a dispersão dos pontos sugere que há variabilidade nos dados que não é completamente explicada pela regressão linear.
# - Isso pode indicar que há outros fatores influenciando a medição de hiperatividade além da quantidade de conservante consumido.
