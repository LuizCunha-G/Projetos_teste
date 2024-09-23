import statsmodels.api as sm
import numpy as np
# Variáveis independentes (X) e dependente (y)
x = np.array([[2, 3], [3, 4], [5, 7], [6, 8], [7, 9]])
y = np.array([5.2, 4.5, 8.3, 8.8, 10.7])
# Adicionando a constante (termo de intercepto)à matriz x
x_const = sm.add_constant(x)
# Criando e ajustando o modelo OLS (regressão múltipla)
modelo = sm.OLS(y, x_const)
resultado = modelo.fit()
# Exibindo o resumo do modelo ajustado
print(resultado.summary())