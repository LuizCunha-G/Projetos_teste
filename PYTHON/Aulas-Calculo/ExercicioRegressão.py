import numpy as np
import matplotlib.pyplot as plt
from scipy import stats
import statsmodels.api as sm

x = [36, 82, 45, 49, 21, 24, 58, 73, 85, 52]
y = [6, 14, 5, 13, 5, 8, 14, 11, 18, 6]

plt.scatter(x, y)
plt.xlabel('Quantidade de conservante (g)')
plt.ylabel('Medição de hiperatividade')
plt.title('Dispersão: Quantidade de Conservante x Hiperatividade')
plt.grid(True)
plt.show()

solucao = stats.linregress(x, y)
a, b = solucao.slope, solucao.intercept

def formula(a, b, c):
    return a * c + b

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

quantidade_conservante = 65
estimativa_hiperatividade = formula(a, b, quantidade_conservante)
print(f"Estimativa de hiperatividade para 65g de conservante: {estimativa_hiperatividade:.2f}")

print()
print()

semanas_Trabalhadas = [2, 7, 9, 1, 5, 12]
carros_Inspecionados = [13, 21, 23, 14, 15, 21]

solucao = stats.linregress(semanas_Trabalhadas, carros_Inspecionados)
coef_angular = solucao.slope
coef_linear = solucao.intercept

print(f"Coeficiente angular (inclinação da reta): {coef_angular:.4f}")
print(f"Coeficiente linear (intercepto da reta): {coef_linear:.4f}")

semanas_estimada = 8
carros_estimados = coef_angular * semanas_estimada + coef_linear
print(f"Estimativa de carros inspecionados após {semanas_estimada} semanas: {carros_estimados:.2f}")

plt.scatter(semanas_Trabalhadas, carros_Inspecionados, label='Dados Reais')
x_vals = np.array(semanas_Trabalhadas)
y_vals = coef_angular * x_vals + coef_linear
plt.plot(x_vals, y_vals, color='orange', label=f'Reta de regressão: y = {coef_angular:.4f}x + {coef_linear:.4f}')
plt.xlabel('Semanas Trabalhadas')
plt.ylabel('Carros Inspecionados')
plt.title('Semanas Trabalhadas x Carros Inspecionados')
plt.legend()
plt.grid(True)
plt.show()

print()
print()

precipitacao = [12.9, 7.2, 11.3, 18.6, 8.8, 10.3, 15.9, 13.1]
safra_trigo = [62.5, 28.7, 52.2, 80.6, 41.6, 44.5, 71.3, 54.4]

solucao = stats.linregress(precipitacao, safra_trigo)
coef_angular = solucao.slope
coef_linear = solucao.intercept
r_value = solucao.rvalue

print(f"Coeficiente angular (inclinação da reta): {coef_angular:.4f}")
print(f"Coeficiente linear (intercepto da reta): {coef_linear:.4f}")
print(f"Coeficiente de correlação (R): {r_value:.4f}")
print(f"Coeficiente de determinação (R²): {r_value**2:.4f}")

def prever_safra(precipitacao):
    return coef_angular * precipitacao + coef_linear

indices_pluviometricos = [9.5, 17.1, 6.8]
estimativas_safra = [prever_safra(p) for p in indices_pluviometricos]

for i, estimativa in zip(indices_pluviometricos, estimativas_safra):
    print(f"Estimativa da safra de trigo para {i} cm de precipitação: {estimativa:.2f} sacos/hectare")

plt.scatter(precipitacao, safra_trigo, label='Dados Reais')
x_vals = np.array(precipitacao)
y_vals = coef_angular * x_vals + coef_linear
plt.plot(x_vals, y_vals, color='orange', label=f'Reta de regressão: y = {coef_angular:.4f}x + {coef_linear:.4f}')
plt.xlabel('Precipitação Pluviométrica (cm)')
plt.ylabel('Safra de Trigo (sacos/hectare)')
plt.title('Precipitação Pluviométrica x Safra de Trigo')
plt.legend()
plt.grid(True)
plt.show()

print()
print()

quartos = [3, 2, 4, 2, 3, 2, 5, 4]
banheiros = [2, 1, 3, 1, 2, 2, 3, 2]
precos = [143.8, 109.3, 158.8, 109.2, 154.7, 114.9, 188.4, 142.9]

X = np.column_stack((quartos, banheiros))
X = sm.add_constant(X)
y = precos

modelo = sm.OLS(y, X).fit()
print(modelo.summary())

a0, a1, a2 = modelo.params
print(f"Equação de regressão: preço = {a0:.4f} + {a1:.4f}*quartos + {a2:.4f}*banheiros")

quartos_estimar = 3
banheiros_estimar = 1
preco_estimado = a0 + a1 * quartos_estimar + a2 * banheiros_estimar
print(f"Preço estimado para uma casa com 3 quartos e 1 banheiro: ${preco_estimado:.2f} mil dólares")

print()
print()

dureza = [78.9, 55.2, 80.9, 57.4, 85.3, 60.7]
cobre = [0.02, 0.02, 0.10, 0.10, 0.18, 0.18]
temperatura = [1000, 1200, 1000, 1200, 1000, 1200]

X = np.column_stack((cobre, temperatura))
X = sm.add_constant(X)
y = dureza

modelo = sm.OLS(y, X).fit()
print(modelo.summary())

a0, a1, a2 = modelo.params
print(f"Equação de regressão: dureza = {a0:.4f} + {a1:.4f}*cobre + {a2:.4f}")

cobre_estimar = 0.15
temperatura_estimar = 1100
dureza_estimado = a0 + a1 * cobre_estimar + a2 * temperatura_estimar
print(f"Estimativa de dureza para cobre de {cobre_estimar:.2f}% e temperatura de {temperatura_estimar}°C: {dureza_estimado:.2f}")

print()
print()

idade = [25, 30, 35, 40, 45, 50, 55, 60]
renda = [30, 35, 40, 45, 60, 70, 80, 90]

solucao = stats.linregress(idade, renda)
coef_angular = solucao.slope
coef_linear = solucao.intercept

print(f"Coeficiente angular (inclinação da reta): {coef_angular:.4f}")
print(f"Coeficiente linear (intercepto da reta): {coef_linear:.4f}")

idade_estimada = 55
renda_estimados = coef_angular * idade_estimada + coef_linear
print(f"Estimativa de renda para {idade_estimada} anos: {renda_estimados:.2f} mil dólares")

plt.scatter(idade, renda, label='Dados Reais')
x_vals = np.array(idade)
y_vals = coef_angular * x_vals + coef_linear
plt.plot(x_vals, y_vals, color='orange', label=f'Reta de regressão: y = {coef_angular:.4f}x + {coef_linear:.4f}')
plt.xlabel('Idade (anos)')
plt.ylabel('Renda (milhares de dólares)')
plt.title('Idade x Renda')
plt.legend()
plt.grid(True)
plt.show()
