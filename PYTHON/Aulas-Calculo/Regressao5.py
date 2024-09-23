import numpy as np
import statsmodels.api as sm

# Dados fornecidos
dureza = [78.9, 55.2, 80.9, 57.4, 85.3, 60.7]  # Dureza (Rockwell 30T)
cobre = [0.02, 0.02, 0.10, 0.10, 0.18, 0.18]   # Conteúdo de cobre (percentagem)
temperatura = [1000, 1200, 1000, 1200, 1000, 1200]  # Temperatura de têmpera (°F)

# Variáveis independentes (conteúdo de cobre e temperatura de têmpera)
X = np.column_stack((cobre, temperatura))

# Adicionar uma constante (intercepto) ao modelo
X = sm.add_constant(X)

# Variável dependente (dureza)
y = dureza

# Criar o modelo de regressão linear múltipla
modelo = sm.OLS(y, X).fit()

# Exibir o resumo do modelo
print(modelo.summary())

# Coeficientes da equação de regressão
a0, a1, a2 = modelo.params
print(f"Equação de regressão: dureza = {a0:.4f} + {a1:.4f}*conteúdo de cobre + {a2:.4f}*temperatura")

# 2. Estimativa da dureza para conteúdo de cobre de 0,14% e temperatura de 1100°F
cobre_estimar = 0.14
temperatura_estimar = 1100
dureza_estimada = a0 + a1 * cobre_estimar + a2 * temperatura_estimar
print(f"Dureza estimada para cobre de 0,14% e temperatura de 1100°F: {dureza_estimada:.2f}")
