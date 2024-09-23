import numpy as np
import matplotlib.pyplot as plt
from scipy import stats

# Dados
semanas_Trabalhadas = [2, 7, 9, 1, 5, 12]
carros_Inspecionados = [13, 21, 23, 14, 15, 21]

# Regressão linear
solucao = stats.linregress(semanas_Trabalhadas, carros_Inspecionados)
coef_angular = solucao.slope
coef_linear = solucao.intercept

# Exibir os coeficientes
print(f"Coeficiente angular (inclinação da reta): {coef_angular:.4f}")
print(f"Coeficiente linear (intercepto da reta): {coef_linear:.4f}")

# 1. Estimativa para 8 semanas
semanas_estimada = 8
carros_estimados = coef_angular * semanas_estimada + coef_linear
print(f"Estimativa de carros inspecionados após {semanas_estimada} semanas: {carros_estimados:.2f}")

# 2. Gráfico de dispersão e reta de regressão
plt.scatter(semanas_Trabalhadas, carros_Inspecionados, label='Dados Reais')

# Gerar valores para a linha de regressão
x_vals = np.array(semanas_Trabalhadas)
y_vals = coef_angular * x_vals + coef_linear

# Plotar a linha de regressão
plt.plot(x_vals, y_vals, color='orange', label=f'Reta de regressão: y = {coef_angular:.4f}x + {coef_linear:.4f}')

# Personalizar o gráfico
plt.xlabel('Semanas Trabalhadas')
plt.ylabel('Carros Inspecionados')
plt.title('Semanas Trabalhadas x Carros Inspecionados')
plt.legend()
plt.grid(True)
plt.show()
