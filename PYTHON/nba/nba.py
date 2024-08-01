import random
import time
from prompt_toolkit import PromptSession
from prompt_toolkit.completion import WordCompleter

# Cores ANSI para terminal
COR_VERDE = "\033[92m"
COR_VERMELHA = "\033[91m"
COR_AMARELO = "\033[93m"  # Adicionando a cor amarela
COR_RESET = "\033[0m"

# Definir as estatísticas dos jogadores
jogadores = {
    "LeBron James": {"PPG": 31.4, "PER": 31.7},  # Temporada 2013-14
    "Stephen Curry": {"PPG": 30.1, "PER": 31.5},  # Temporada 2015-16
    "Kevin Durant": {"PPG": 32.0, "PER": 30.6},  # Temporada 2013-14
    "Giannis Antetokounmpo": {"PPG": 31.9, "PER": 31.9},  # Temporada 2020-21
    "Kawhi Leonard": {"PPG": 30.4, "PER": 29.0},  # Temporada 2019-20
    "James Harden": {"PPG": 36.1, "PER": 30.6},  # Temporada 2018-19
    "Anthony Davis": {"PPG": 28.1, "PER": 30.0},  # Temporada 2017-18
    "Luka Dončić": {"PPG": 32.4, "PER": 28.3},  # Temporada 2021-22
    "Jayson Tatum": {"PPG": 30.0, "PER": 26.7},  # Temporada 2022-23
    "Damian Lillard": {"PPG": 32.0, "PER": 27.3},  # Temporada 2019-20
    "Joel Embiid": {"PPG": 33.1, "PER": 31.8},  # Temporada 2022-23
    "Devin Booker": {"PPG": 27.7, "PER": 26.4},  # Temporada 2021-22
    "Zion Williamson": {"PPG": 27.0, "PER": 27.3},  # Temporada 2022-23
    "Ben Simmons": {"PPG": 16.4, "PER": 17.6},  # Temporada 2018-19
    "Russell Westbrook": {"PPG": 31.6, "PER": 30.5},  # Temporada 2016-17
    "Paul George": {"PPG": 28.0, "PER": 26.6},  # Temporada 2018-19
    "Kyrie Irving": {"PPG": 27.4, "PER": 25.6},  # Temporada 2018-19
    "John Wall": {"PPG": 23.1, "PER": 20.8},  # Temporada 2016-17
    "Draymond Green": {"PPG": 14.0, "PER": 22.4},  # Temporada 2015-16
    "Clint Capela": {"PPG": 20.6, "PER": 22.2},  # Temporada 2018-19
    "Rudy Gobert": {"PPG": 15.1, "PER": 22.4},  # Temporada 2021-22
    "Trae Young": {"PPG": 29.6, "PER": 24.8},  # Temporada 2021-22
}

# Inicializar a tabela de classificação
classificacao = {jogador: 0 for jogador in jogadores.keys()}

def simular_partida(jogador1, jogador2):
    pontos_jogador1 = 0
    pontos_jogador2 = 0
    PONTOS_PARA_VENCER = 21  # Alterar a pontuação para vencer para 21

    while pontos_jogador1 < PONTOS_PARA_VENCER and pontos_jogador2 < PONTOS_PARA_VENCER:
        sorte1 = random.uniform(0, 5)
        sorte2 = random.uniform(0, 5)
        total_jogador1 = (jogadores[jogador1]["PPG"] * 0.5) + (jogadores[jogador1]["PER"] * 0.5) + sorte1
        total_jogador2 = (jogadores[jogador2]["PPG"] * 0.5) + (jogadores[jogador2]["PER"] * 0.5) + sorte2

        if total_jogador1 > total_jogador2:
            pontos_jogador1 += 1
        else:
            pontos_jogador2 += 1

    vencedor = jogador1 if pontos_jogador1 == PONTOS_PARA_VENCER else jogador2
    classificacao[vencedor] += 1
    return vencedor, pontos_jogador1, pontos_jogador2

def gerar_confrontos_rodada(jogadores, favorito=None):
    jogadores_list = list(jogadores.keys())
    random.shuffle(jogadores_list)
    confrontos = []
    if favorito:
        jogadores_list.remove(favorito)
        jogadores_list = [favorito] + jogadores_list

    for i in range(0, len(jogadores_list)-1, 2):
        confrontos.append((jogadores_list[i], jogadores_list[i+1]))

    return confrontos

def exibir_confrontos_rodada(confrontos, rodada_atual):
    print(f"\nConfrontos da Rodada {rodada_atual}:")
    for i, (j1, j2) in enumerate(confrontos, start=1):
        print(f"{i}. {j1} vs {j2}")

def exibir_confrontos_possiveis(confrontos_realizados):
    confrontos = [(j1, j2) for j1 in jogadores.keys() for j2 in jogadores.keys() if j1 != j2]
    confrontos_nao_realizados = [confronto for confronto in confrontos if confronto not in confrontos_realizados and (confronto[1], confronto[0]) not in confrontos_realizados]

    if confrontos_nao_realizados:
        print("\nConfrontos possíveis não realizados:")
        for i, (j1, j2) in enumerate(confrontos_nao_realizados, start=1):
            print(f"{i}. {j1} vs {j2}")
    else:
        print("\nTodos os confrontos foram realizados.")

def exibir_classificacao_final():
    print("\nClassificação Final:")
    classificacao_ordenada = sorted(classificacao.items(), key=lambda x: x[1], reverse=True)
    for jogador, vitorias in classificacao_ordenada:
        print(f"{jogador}: {vitorias} vitórias")

# Configuração do autocompletar
completer = WordCompleter(jogadores.keys(), ignore_case=True)
session = PromptSession(completer=completer)

# Introdução e confirmação para iniciar o torneio
print("Bem-vindo ao Torneio de Basquete da NBA!")
print("Neste torneio, cada jogador enfrentará todos os outros jogadores em confrontos diretos.")
print("Cada partida é jogada até que um jogador alcance 21 pontos.")
print("O jogador com mais vitórias ao final do torneio será o vencedor.")

# Exibir opções de jogadores
print("\nJogadores disponíveis:")
for i, jogador in enumerate(jogadores.keys(), start=1):
    print(f"{i}. {jogador}")

# Escolha do jogador favorito
favorito = session.prompt("\nDigite o nome do jogador favorito (deixe em branco se não quiser destacar nenhum jogador): ").strip()
if favorito and favorito not in jogadores:
    print("O jogador escolhido não está na lista. Nenhum jogador favorito será destacado.")
    favorito = None

rodada_atual = 1
confrontos_realizados = set()
finalizado = False

while not finalizado:
    confrontos_rodada = gerar_confrontos_rodada(jogadores, favorito)
    exibir_confrontos_rodada(confrontos_rodada, rodada_atual)

    for i, (jogador1, jogador2) in enumerate(confrontos_rodada, start=1):
        if rodada_atual == 1 and i > 1:
            print("\nDigite 'fim' ou 'end' a qualquer momento para finalizar o campeonato.")

        jogador_favorito = session.prompt(f"\nDigite o nome do jogador favorito para destaque no confronto {i} ({jogador1} vs {jogador2}) (deixe em branco se não quiser destacar nenhum jogador): ")

        print("\nAguardando Jogadores..", end="")
        for _ in range(3):  # Ajuste o tempo de espera aqui, atualmente 3 segundos
            print(".", end="", flush=True)
            time.sleep(1)
        print()

        session.prompt("\nPressione Enter para iniciar o confronto...")

        print("\nEsperando confronto...", end="")
        for _ in range(3):  # Ajuste o tempo de espera aqui, atualmente 3 segundos
            print(".", end="", flush=True)
            time.sleep(1)
        print()

        # Simulação do confronto selecionado
        vencedor, pontos_jogador1, pontos_jogador2 = simular_partida(jogador1, jogador2)
        destaque = f" ({COR_AMARELO}Favorito{COR_RESET})" if jogador_favorito in [jogador1, jogador2] else ""
        
        # Exibir o resultado com cores
        if vencedor == jogador1:
            print(f"\n{COR_VERDE}{jogador1}{COR_RESET} vs {COR_VERMELHA}{jogador2}{COR_RESET} -> Vencedor: {jogador1}{destaque}")
        else:
            print(f"\n{COR_VERMELHA}{jogador1}{COR_RESET} vs {COR_VERDE}{jogador2}{COR_RESET} -> Vencedor: {jogador2}{destaque}")
        
        print(f"Placar: {jogador1} {pontos_jogador1} - {pontos_jogador2} {jogador2}")

        confrontos_realizados.add((jogador1, jogador2))

        # Verificar se o usuário digitou 'fim' ou 'end'
        comando = session.prompt("\nDigite 'fim' ou 'end' para finalizar o campeonato, ou pressione Enter para continuar: ").strip().lower()
        if comando in ['fim', 'end']:
            print("\nO campeonato está sendo finalizado...")
            finalizado = True
            break

    rodada_atual += 1

# Simular todos os confrontos restantes
todos_confrontos = [(j1, j2) for j1 in jogadores.keys() for j2 in jogadores.keys() if j1 != j2]
confrontos_nao_realizados = [confronto for confronto in todos_confrontos if confronto not in confrontos_realizados and (confronto[1], confronto[0]) not in confrontos_realizados]

for confronto in confrontos_nao_realizados:
    simular_partida(confronto[0], confronto[1])

# Exibir a classificação final
exibir_classificacao_final()
