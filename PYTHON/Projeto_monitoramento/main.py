import psutil
import customtkinter as ct
import os

ct.set_appearance_mode("Dark")
ct.set_default_color_theme("dark-blue")
app = ct.CTk()
app.geometry("640x480")
app.title("System Monitorator")

# Caminho para o ícone
icone_caminho = "appicon.ico"

# Tenta carregar o ícone, tratando possíveis erros
if os.path.exists(icone_caminho):
    try:
        app.iconbitmap(icone_caminho)
    except Exception as e:
        print(f"Erro ao carregar o ícone: {e}")
else:
    print(f"Arquivo de ícone não encontrado: {icone_caminho}")

app.resizable(False, False)

label_titulo = ct.CTkLabel(app, text="Monitor Do Sistema", font=("arial", 50), text_color="#14747F")
label_titulo.place(x=100, y=25)

def show_cpu_info():
    cpu_uso = psutil.cpu_percent(interval=1)
    cpu_freq = psutil.cpu_freq()
    cpu_freq = dict(cpu_freq._asdict())
    frequencia_cpu = cpu_freq['current']

    cpu_label.configure(text="{}% / {} MHz".format(cpu_uso, frequencia_cpu))
    cpu_label.after(1000, show_cpu_info)  # Ajustado para atualizar de acordo com o intervalo de cpu_percent

def converter_bytes_para_gb(byte):
    one_gigabyte = 1073741824
    giga = byte / one_gigabyte
    return "{0:.1f}".format(giga)

def show_ram_info():
    ram_uso = psutil.virtual_memory()
    ram_uso = dict(ram_uso._asdict())
    for key in ram_uso:
        if key != "percent":
            ram_uso[key] = converter_bytes_para_gb(ram_uso[key])
    ram_label.configure(text="{} GB / {} GB ({} %)".format(ram_uso["used"], ram_uso["total"], ram_uso["percent"]))
    ram_label.after(1000, show_ram_info)  # Atualização sincronizada com a CPU

def show_hd_info():
    disk_textbox.delete("1.0", "end")  # Limpa o textbox antes de atualizar
    partitions = psutil.disk_partitions()

    for partition in partitions:
        uso_disco = psutil.disk_usage(partition.mountpoint)  # mountpoint é mais confiável para obter o uso
        uso_disco = dict(uso_disco._asdict())
        for key in uso_disco:
            if key != "percent":
                uso_disco[key] = converter_bytes_para_gb(uso_disco[key])
        disk_textbox.insert("end", "{} {} GB / {} GB ({} GB LIVRE)\n".format(partition.device.replace("\\", ">"), 
                                                                            uso_disco["used"], 
                                                                            uso_disco["total"], 
                                                                            uso_disco["free"]))
    disk_textbox.after(5000, show_hd_info)  # Atualiza informações de disco a cada 5 segundos

# Labels e Textboxes
cpu_title_label = ct.CTkLabel(app, text="USO DO CPU:", font=("arial", 30), text_color="#FA5125")
cpu_title_label.place(x=35, y=125)

cpu_label = ct.CTkLabel(app, text="TESTE", font=("arial", 30))
cpu_label.place(x=250, y=125)

ram_title_label = ct.CTkLabel(app, text="USO DA RAM:", font=("arial", 30), text_color="#34A96C")
ram_title_label.place(x=35, y=200)

ram_label = ct.CTkLabel(app, text="TESTE", font=("arial", 30))
ram_label.place(x=250, y=200)

disk_title_label = ct.CTkLabel(app, text="USO DE DISCO:", font=("arial", 30), text_color="#797E1E")
disk_title_label.place(x=200, y=275)

disk_textbox = ct.CTkTextbox(app, bg_color="#071C1E", text_color="yellow", width=605, height=150, padx=10, font=("arial", 20))
disk_textbox.place(x=15, y=325)
    
if __name__ == "__main__":
    show_cpu_info()
    show_ram_info()
    show_hd_info()
    app.mainloop()

