import numpy as np
import statsmodels.api as sm

# Dados: número de quartos, número de banheiros e preço (em milhares de dólares)
quartos = [3, 2, 4, 2, 3, 2, 5, 4]
banheiros = [2, 1, 3, 1, 2, 2, 3, 2]
precos = [143.8, 109.3, 158.8, 109.2, 154.7, 114.9, 188.4, 142.9]  # Preços em milhares de dólares

# Variáveis independentes (quartos e banheiros)
X = np.column_stack((quartos, banheiros))

# Adicionar uma constante (intercepto) ao modelo
X = sm.add_constant(X)

# Variável dependente (preços)
y = precos

# Criar o modelo de regressão linear múltipla
modelo = sm.OLS(y, X).fit()

# Exibir o resumo do modelo
print(modelo.summary())

# Coeficientes da equação
a0, a1, a2 = modelo.params
print(f"Equação de regressão: preço = {a0:.4f} + {a1:.4f}*quartos + {a2:.4f}*banheiros")

# 2. Estimativa do preço para uma casa com 3 quartos e 1 banheiro
quartos_estimar = 3
banheiros_estimar = 1
preco_estimado = a0 + a1 * quartos_estimar + a2 * banheiros_estimar
print(f"Preço estimado para uma casa com 3 quartos e 1 banheiro: ${preco_estimado:.2f} mil dólares")
