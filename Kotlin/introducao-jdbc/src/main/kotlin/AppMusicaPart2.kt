package org.example

fun main() {
    val musicaRepositorio = MusicaRepositoria()
    musicaRepositorio.configurar()
    musicaRepositorio.criarTabela()

    val novaMusica = Musica(nome = "Diggy Diggy Hole", banda = "Rock de Anão", produtor = "Produtora top")
    val sucesso = musicaRepositorio.inserir(novaMusica)

    if (sucesso) {
        println("Inserido com sucesso!")
    } else {
        println("Deu ruim")
    }

    val listarMusicas = musicaRepositorio.listar()
    listarMusicas.forEach {
        println("""
            Id: ${it.id}
            Nome: ${it.nome}
            Banda: ${it.banda}
            Produtor: ${it.produtor}
        """.trimIndent())
    }

    val idParaBusca = 1
    if (musicaRepositorio.existePorId(idParaBusca)) {
        val musicaEncontrada = musicaRepositorio.buscarPorId(idParaBusca)
        println("Nome: ${musicaEncontrada.nome}")
    } else {
        println("Musica não existe!")
    }

    musicaRepositorio.inserir(Musica(nome = "Hotel California", banda = "Eagles", produtor = "TOP"))

    if (musicaRepositorio.existePorId(idParaBusca)) {
        val deletado = musicaRepositorio.deletarPorId(idParaBusca)
        println(if (deletado) "Deletado!" else "Não foi possível deletar")
    } else {
        println("Musica não existe!")
    }

    if (musicaRepositorio.existePorId(2)) {
        val musicaAtualizada = Musica(nome = "Californication", banda = "RHCP", produtor = "Na California")
        val atualizado = musicaRepositorio.atualizarPorId(2, musicaAtualizada)
        println(if (atualizado) "Atualizado!" else "Deu ruim")
    } else {
        println("Musica não existe!")
    }
}