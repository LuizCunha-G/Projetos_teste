import numpy as np
import statsmodels.api as sm

# Dados fornecidos
medicamento_a = [15, 15, 15, 15, 30, 30, 30, 30, 45, 45, 45, 45]  # Quantidade de medicamento A (mg)
medicamento_b = [20, 20, 30, 30, 20, 20, 30, 30, 20, 20, 30, 30]  # Quantidade de medicamento B (mg)
medicamento_c = [10, 20, 10, 20, 10, 20, 10, 20, 10, 20, 10, 20]  # Quantidade de medicamento C (mg)
eficacia_percentual = [47, 54, 58, 66, 59, 67, 71, 83, 72, 82, 85, 94]  # Eficácia percentual (%)

# Variáveis independentes (medicamentos A, B e C)
X = np.column_stack((medicamento_a, medicamento_b, medicamento_c))

# Adicionar uma constante (intercepto) ao modelo
X = sm.add_constant(X)

# Variável dependente (eficácia percentual)
y = eficacia_percentual

# Criar o modelo de regressão linear múltipla
modelo = sm.OLS(y, X).fit()

# Exibir o resumo do modelo
print(modelo.summary())

# Coeficientes da equação de regressão
a0, a1, a2, a3 = modelo.params
print(f"Equação de regressão: y = {a0:.4f} + {a1:.4f}*medicamento A + {a2:.4f}*medicamento B + {a3:.4f}*medicamento C")

# 2. Estimativa da eficácia para medicamento A = 12.5, B = 25, C = 15
medicamento_a_estimar = 12.5
medicamento_b_estimar = 25
medicamento_c_estimar = 15
eficacia_estimada = a0 + a1 * medicamento_a_estimar + a2 * medicamento_b_estimar + a3 * medicamento_c_estimar
print(f"Eficácia estimada para A=12.5 mg, B=25 mg, C=15 mg: {eficacia_estimada:.2f}%")
