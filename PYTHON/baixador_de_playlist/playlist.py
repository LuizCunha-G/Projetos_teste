from pytube import YouTube, Playlist
from os import system, name, makedirs
from tkinter import *
from tkinter import messagebox
import requests
from spotipy.oauth2 import SpotifyClientCredentials
import spotipy

# Função que baixa a playlist do YouTube
def download_youtube_playlist():
    system(f'{exec} aviso.py BAiXANDO...')    
    try:
        pl = playl.get()
        nome = nomepl.get()
        
        if not os.path.exists(nome):
            os.makedirs(nome)
        
        playlist = Playlist(pl)
        
        for url in playlist:
            yt = YouTube(url)
            audio = yt.streams.filter(only_audio=True).first()
            if audio:
                audio.download(output_path=nome)
            else:
                messagebox.showwarning("Aviso", f"Não foi possível encontrar áudio para {url}")
        
        system(f'{exec} aviso.py Playlist Baixada')  
        messagebox.showinfo("Sucesso", "Playlist Baixada com Sucesso!")
    except Exception as e:
        system(f'{exec} aviso.py Ocorreu Algum Erro')  
        messagebox.showerror("Erro", f"Ocorreu um erro: {e}")

# Função para buscar playlists no Deezer
def search_deezer_playlist():
    query = playl.get()
    url = f"https://api.deezer.com/search/playlist?q={query}"
    response = requests.get(url)
    if response.status_code == 200:
        data = response.json()
        playlists = data.get('data', [])
        if playlists:
            results = "\n".join([f"Playlist: {playlist['title']}, URL: {playlist['link']}" for playlist in playlists])
            messagebox.showinfo("Playlists do Deezer", results)
        else:
            messagebox.showinfo("Playlists do Deezer", "Nenhuma playlist encontrada.")
    else:
        messagebox.showerror("Erro", "Erro ao buscar playlists no Deezer.")

# Função para buscar playlists no Spotify
def search_spotify_playlist():
    query = playl.get()
    sp = spotipy.Spotify(auth_manager=SpotifyClientCredentials(client_id='your_client_id', client_secret='your_client_secret'))
    results = sp.search(q=f'playlist:{query}', type='playlist')
    playlists = results['playlists']['items']
    if playlists:
        results = "\n".join([f"Playlist: {playlist['name']}, URL: {playlist['external_urls']['spotify']}" for playlist in playlists])
        messagebox.showinfo("Playlists do Spotify", results)
    else:
        messagebox.showinfo("Playlists do Spotify", "Nenhuma playlist encontrada.")

# Tela
tela = Tk()
tela.title('Baixador de Playlist')
tela.resizable(True, True)
tela.geometry('800x600')
tela['bg'] = '#2E2E2E'  # Cor de fundo escura

# Usado para compatibilidade entre Windows e Linux
if name == 'nt':
    exec = 'python'
else:
    exec = 'python3'

# Título no topo da tela
titulo = Label(tela, text='Baixador De Playlist', font='Arial 24 bold', fg='#FFD700', bg='#2E2E2E')
titulo.pack(pady=20)

# Frame para as entradas
frame_entries = Frame(tela, bg='#2E2E2E')
frame_entries.pack(pady=10)

# Mensagem
msg = Label(frame_entries, text='Link da Playlist:', font='Arial 14', fg='#FFFFFF', bg='#2E2E2E')
msg.grid(row=0, column=0, padx=10, pady=5, sticky=W)

# Entry que recebe o link da playlist
playl = Entry(frame_entries, width=60, font='Arial 12')
playl.grid(row=0, column=1, padx=10, pady=5)

# Segunda mensagem
msg2 = Label(frame_entries, text='Nome da Pasta de Destino:', font='Arial 14', fg='#FFFFFF', bg='#2E2E2E')
msg2.grid(row=1, column=0, padx=10, pady=5, sticky=W)

# Entry que recebe a pasta de destino
nomepl = Entry(frame_entries, width=60, font='Arial 12')
nomepl.grid(row=1, column=1, padx=10, pady=5)

# Frame para os botões
frame_buttons = Frame(tela, bg='#2E2E2E')
frame_buttons.pack(pady=20)

# Botão que chama a função de baixar do YouTube
baixar_youtube = Button(frame_buttons, text='Baixar do YouTube', width=20, height=2, font='Arial 12 bold', fg='#FFFFFF', bg='#FF4500', command=download_youtube_playlist)
baixar_youtube.grid(row=0, column=0, padx=20, pady=10)

# Botão que chama a função de buscar playlists do Deezer
buscar_deezer = Button(frame_buttons, text='Buscar no Deezer', width=20, height=2, font='Arial 12 bold', fg='#FFFFFF', bg='#1DB954', command=search_deezer_playlist)
buscar_deezer.grid(row=0, column=1, padx=20, pady=10)

# Botão que chama a função de buscar playlists do Spotify
buscar_spotify = Button(frame_buttons, text='Buscar no Spotify', width=20, height=2, font='Arial 12 bold', fg='#FFFFFF', bg='#1DB954', command=search_spotify_playlist)
buscar_spotify.grid(row=0, column=2, padx=20, pady=10)

tela.mainloop()
