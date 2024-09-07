fun insertPlayer(player: Player) {
    val connection = Database.connect()
    val statement = connection.prepareStatement(
        "INSERT INTO Players (name, position, birth_date, age, nationality, positions_played) VALUES (?, ?, ?, ?, ?, ?)"
    )
    statement.setString(1, player.name)
    statement.setString(2, player.position)
    statement.setString(3, player.birthDate)
    statement.setInt(4, player.age ?: 0)
    statement.setString(5, player.nationality)
    statement.setString(6, player.positionsPlayed)
    statement.executeUpdate()
    statement.close()
    connection.close()
}
