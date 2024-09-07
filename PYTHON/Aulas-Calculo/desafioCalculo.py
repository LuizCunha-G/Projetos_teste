corretora_agora = {'ITSA4', 'ECOR3', 'TAEE11', 'B3SA3', 'VALE3'}

corretora_ativa = {'B3SA3', 'BBDC4', 'BBSE3', 'BRDT3', 'TAEE11', 'VIVT3', 'TRPL4'}

corretora_genial = {'CPFE3', 'BEEF3', 'CYRE3', 'SAPT4', 'TRPL4'}

corretora_easynvest = {'B3SA3', 'AGRO3', 'TAEE11', 'VALE3', 'CPLE11', 'ITSA4', 'ABEV3', 'BBDC4', 'BBSE3', 'BRFS3', 'EGIE3', 'SAPR11'}

corretora_elite = {'B3SA3', 'AGRO3', 'COCA34', 'TAEE11', 'VALE3', 'CPLE11', 'ITSA4', 'ABEV3', 'BBDC4', 'BBSE3', 'BRFS3', 'EGIE3', 'SAPR11', 'TRPL4'}

corretora_guide = {'ALUP11', 'BBAS3', 'CYRE3', 'CPFE3', 'KLBN11', 'PSSA3', 'TIMS3'}

corretora_nova_futura = {'B3SA3', 'CYRE3', 'GGBR4', 'VIVT3'}

corretora_orama = {'ABC14', 'ABCB4', 'B3SA3', 'BRAP4', 'CPFE3', 'EGIE3'}

#Formando os portfolios dentro dos conjuntos de cada corretora


#Verificando se há alguma empresa presente em todas as carteiras
interseccao_todas = (
    corretora_ativa & corretora_easynvest & corretora_elite &
    corretora_nova_futura & corretora_orama & corretora_genial

)

print(interseccao_todas)
print()

# Selecionando quatro corretoras e vereficando se há alguma ação igual indicada
interseccao1 = corretora_ativa & corretora_easynvest & corretora_nova_futura & corretora_elite
print("Intersecção")
print(interseccao1)
print()

diferenca = corretora_ativa ^ corretora_easynvest ^ corretora_nova_futura ^ corretora_elite
print("Diferença")
print(diferenca)

interseccao4 = (
    corretora_ativa, corretora_easynvest, corretora_nova_futura, corretora_elite

)

print()

# Verificar se algum conjunto é subset ou superset de outro
print("Ágora é subset de Ativa:", corretora_agora.issubset(corretora_ativa))
print("Ágora é subset de Easynvest:", corretora_agora.issubset(corretora_easynvest))
print("Ágora é subset de Elite:", corretora_agora.issubset(corretora_elite))

print("Easynvest é superset de Ativa:", corretora_easynvest.issuperset(corretora_ativa))
print("Easynvest é superset de Elite:", corretora_easynvest.issuperset(corretora_elite))


# Conjunto de ações únicas de cada corretora
acoes_unicas_agora = corretora_agora - (corretora_ativa | corretora_easynvest | corretora_elite)
acoes_unicas_ativa = corretora_ativa - (corretora_agora | corretora_easynvest | corretora_elite)
acoes_unicas_easynvest = corretora_easynvest - (corretora_agora | corretora_ativa | corretora_elite)
acoes_unicas_elite = corretora_elite - (corretora_agora | corretora_ativa | corretora_easynvest)

print("Ações únicas de Ágora:", acoes_unicas_agora)
print("Ações únicas de Ativa:", acoes_unicas_ativa)
print("Ações únicas de Easynvest:", acoes_unicas_easynvest)
print("Ações únicas de Elite:", acoes_unicas_elite)