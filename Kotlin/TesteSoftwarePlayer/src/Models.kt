data class Player(
    val id: Int,
    val name: String,
    val position: String?,
    val birthDate: String?,
    val age: Int?,
    val nationality: String?,
    val positionsPlayed: String?
)

data class Team(
    val id: Int,
    val name: String,
    val country: String
)

data class Season(
    val id: Int,
    val year: String,
    val playerId: Int,
    val teamId: Int,
    val joinedYear: String?,
    val seasonsPlayed: Int?,
    val titlesWon: Int?,
    val championshipsContested: Int?,
    val individualAwards: String?,
    val goals: Int?,
    val games: Int?,
    val assists: Int?,
    val wins: Int?,
    val draws: Int?,
    val losses: Int?,
    val overall: Float?
)
