fun main() {
    val player = Player(
        id = 0,  // ID será gerado automaticamente
        name = "Cristiano Ronaldo",
        position = "Atacante",
        birthDate = "1985-02-05",
        age = 39,
        nationality = "Português",
        positionsPlayed = "Atacante, Meia"
    )

    insertPlayer(player)
    println("Jogador inserido com sucesso!")
}
