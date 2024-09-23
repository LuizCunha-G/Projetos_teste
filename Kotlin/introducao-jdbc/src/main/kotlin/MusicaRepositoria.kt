package org.example
import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject

class MusicaRepositoria {
    lateinit var jdbcTemplate: JdbcTemplate

    fun configurar() {
        val datasource = BasicDataSource()
        datasource.driverClassName = "org.h2.Driver"
        datasource.url = "jdbc:h2:mem:festival"
        datasource.username = "sa"
        datasource.password = ""

        jdbcTemplate = JdbcTemplate(datasource)
    }

    fun criarTabela() {
        jdbcTemplate.execute(
            """
            CREATE TABLE Musica(
                id int PRIMARY KEY AUTO_INCREMENT,
                nome varchar(45) NOT NULL,
                banda varchar(255) NOT NULL,
                produtor varchar(255)
            )
            """.trimIndent()
        )
    }

    fun inserir(novaMusica: Musica): Boolean {
        val qtdLinhasAfetadas = jdbcTemplate.update(
            """
            INSERT INTO Musica (nome, banda, produtor)
            VALUES(?, ?, ?)
            """.trimIndent(),
            novaMusica.nome,
            novaMusica.banda,
            novaMusica.produtor
        )
        return qtdLinhasAfetadas > 0
    }

    fun listar(): List<Musica> {
        return jdbcTemplate.query(
            "SELECT * FROM Musica",
            BeanPropertyRowMapper(Musica::class.java)
        )
    }

    fun existePorId(id: Int): Boolean {
        val qtdExistentes = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM Musica WHERE id = ?",
            Int::class.java,
            id
        )
        return qtdExistentes > 0
    }

    fun buscarPorId(id: Int): Musica {
        val musicaEncontrada = jdbcTemplate.queryForObject(
            "SELECT * FROM Musica WHERE id = ?",
            BeanPropertyRowMapper(Musica::class.java),
            id
        )
        return musicaEncontrada
    }

    fun deletarPorId(id: Int): Boolean {
        val qtdLinhasAfetadas = jdbcTemplate.update(
            "DELETE FROM Musica WHERE id = ?",
            id
        )
        return qtdLinhasAfetadas > 0
    }

    fun atualizarPorId(id: Int, musicaAtualizada: Musica): Boolean {
        val qtdLinhasAfetadas = jdbcTemplate.update(
            """
            UPDATE Musica SET
                nome = ?,
                banda = ?,
                produtor = ?
            WHERE id = ?
            """,
            musicaAtualizada.nome,
            musicaAtualizada.banda,
            musicaAtualizada.produtor,
            id
        )
        return qtdLinhasAfetadas > 0
    }
}