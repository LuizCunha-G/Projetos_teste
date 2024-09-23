import numpy as np
import matplotlib.pyplot as plt
from scipy import stats

# Dados: Precipitação pluviométrica (cm) e Safra de trigo (sacos/hectare)
precipitacao = [12.9, 7.2, 11.3, 18.6, 8.8, 10.3, 15.9, 13.1]
safra_trigo = [62.5, 28.7, 52.2, 80.6, 41.6, 44.5, 71.3, 54.4]

# Regressão linear
solucao = stats.linregress(precipitacao, safra_trigo)
coef_angular = solucao.slope
coef_linear = solucao.intercept
r_value = solucao.rvalue

# Exibir os coeficientes e o coeficiente de determinação R^2
print(f"Coeficiente angular (inclinação da reta): {coef_angular:.4f}")
print(f"Coeficiente linear (intercepto da reta): {coef_linear:.4f}")
print(f"Coeficiente de correlação (R): {r_value:.4f}")
print(f"Coeficiente de determinação (R²): {r_value**2:.4f}")

# Função para prever a safra de trigo dada uma precipitação
def prever_safra(precipitacao):
    return coef_angular * precipitacao + coef_linear

# Estimativas para os índices pluviométricos fornecidos
indices_pluviometricos = [9.5, 17.1, 6.8]
estimativas_safra = [prever_safra(p) for p in indices_pluviometricos]

for i, estimativa in zip(indices_pluviometricos, estimativas_safra):
    print(f"Estimativa da safra de trigo para {i} cm de precipitação: {estimativa:.2f} sacos/hectare")

# 2. Gráfico de dispersão e reta de regressão
plt.scatter(precipitacao, safra_trigo, label='Dados Reais')

# Gerar valores para a linha de regressão
x_vals = np.array(precipitacao)
y_vals = coef_angular * x_vals + coef_linear

# Plotar a linha de regressão
plt.plot(x_vals, y_vals, color='orange', label=f'Reta de regressão: y = {coef_angular:.4f}x + {coef_linear:.4f}')

# Personalizar o gráfico
plt.xlabel('Precipitação Pluviométrica (cm)')
plt.ylabel('Safra de Trigo (sacos/hectare)')
plt.title('Precipitação Pluviométrica x Safra de Trigo')
plt.legend()
plt.grid(True)
plt.show()
