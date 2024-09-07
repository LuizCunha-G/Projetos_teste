import psutil
import datetime
import time

dados_coletados = []

intervalo = 5

contador = 0

while contador < 20:
    a = psutil.cpu_stats()

    data = datetime.datetime.now()

    captura = {
        'cpu_stats': {
            'ctx_switches': a.ctx_switches,
            'interrupts': a.interrupts,
            'soft_interrupts': a.soft_interrupts,
            'syscalls': a.syscalls
        },
        'DATA': datetime.datetime.now()
    }
    ctx_switches = captura['cpu_stats']['ctx_switches']
    interrupts = captura['cpu_stats']['interrupts']
    soft_interrupts = captura['cpu_stats']['soft_interrupts']
    syscalls = captura['cpu_stats']['syscalls']

    dados_coletados.append(captura)
    print('Dados coletados:')
    print('ctx_switches:', ctx_switches, ':contagem de troca de contexto\n', 'interrupts:', interrupts, ':contagem de interrução de hardware\n', 'soft_interrupts:', soft_interrupts, ':contagem de interrupção de software\n', 'syscalls:',syscalls ,':contagem de de chamadas de sistema')
    print('Data e Hora:', data)
    print()

    contador += 1

    time.sleep(intervalo)
