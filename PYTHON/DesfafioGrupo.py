#Grupo 2: Gabriel Cordeiro 03241035, João Otávio, Kevelly Mendes 03241071, Lívia Negrini 03241004, Luiz Gustavo, Marcelo Freschi 03241030

import psutil
import platform
import time
meu_so = platform.system()

print("SO que eu uso: ", meu_so)

memoria = psutil.virtual_memory()

disco = psutil.disk_usage("C:")

cpu = psutil.cpu_percent()


while True:
    print("-" * 50)
    memoria1 = memoria.percent
    cpu1= cpu
    disco1 = disco.percent

    memoria2 = memoria1 + (memoria1 * 0.15)
    memoria3 = memoria1 + (memoria1 * 0.10)

    cpu2 = cpu1 +(cpu1 * 0.1)
    cpu3 = cpu1 +(cpu1 * 0.15)

    disco2 = disco1 - (disco1 * 0.05)
    disco3 = disco2 * 3
    
  
    maquina1 = {"CPU": cpu1, "Memória" : memoria1, "Disco": disco1}
    maquina2 = {"CPU": cpu2, "Memória" : memoria2, "Disco": disco2}
    maquina3 = {"CPU": cpu3, "Memória" : memoria3, "Disco": disco3}
    
    print(f"Maquina 1: CPU: {maquina1['CPU']:.2f}%; Memória: {maquina1['Memória']:.2f}%; Disco: {maquina1['Disco']:.2f}%")
    print(f"Maquina 2: CPU: {maquina2['CPU']:.2f}%; Memória: {maquina2['Memória']:.2f}%; Disco: {maquina2['Disco']:.2f}%")
    print(f"Maquina 3: CPU: {maquina3['CPU']:.2f}%; Memória: {maquina3['Memória']:.2f}%; Disco: {maquina3['Disco']:.2f}%")
    print("-" * 50)
    
    time.sleep(3)
    


