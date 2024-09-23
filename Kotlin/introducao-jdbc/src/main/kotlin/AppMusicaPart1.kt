package org.example
import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

fun main() {

//    val datasource : BasicDataSource = BasicDataSource()
    val datasource = BasicDataSource()
    datasource.driverClassName = "org.h2.Driver"
    // caso eu queira salvar um arquivo no projeto como se fosse um banco
    // datasource.url = "jdbc:h2:file:./festival"
    // jdbc:h2:file:c://caminho...
    datasource.url = "jdbc:h2:mem:festival"
    datasource.username = "sa"
    datasource.password = ""

    val jdbcTemplate = JdbcTemplate(datasource)

    jdbcTemplate.execute("""
       
        CREATE TABLE Musica(
        id int PRIMARY KEY AUTO_INCREMENT,
        nome varchar(45) NOT NULL,
        banda varchar(255) NOT NULL,
        produtor varchar(255)
        )
    """.trimIndent()
    )

     val qtdinseridos = jdbcTemplate.update(
        "INSERT INTO Musica(nome,banda,produtor)"
                + "VALUES('Still loving you','Scorpion', 'Records')")

    println("Linhas afetadas: $qtdinseridos")

    val listaMusicas: List<Musica> = jdbcTemplate.query(
        "SELECT * FROM Musica",
        BeanPropertyRowMapper(Musica::class.java)
    )

    println(listaMusicas[0].nome)

    listaMusicas.forEach{
        println("""
            Id: ${it.id}
            Nome: ${it.nome}
            Banda: ${it.banda}
            Produtor: ${it.produtor}
        """.trimIndent())
    }

    println("=========================================")

    for (it in listaMusicas){
        println("""
            Id: ${it.id}
            Nome: ${it.nome}
            Banda: ${it.banda}
            Produtor: ${it.produtor}
        """.trimIndent())
    }

    val musicaId = 1

    val existeMusica: Boolean = jdbcTemplate.queryForObject(
        "SELECT count(*) FROM Musica WHERE id = ?",
        Int::class.java,
        musicaId
    ) > 0

    if(existeMusica){
        val musicaEncontrada =
            jdbcTemplate.queryForObject(
                "SELECT * FROM Musica WHERE id = ?",
                BeanPropertyRowMapper(Musica::class.java),
                musicaId
            )

        println("""
            -----BUSCA POR ID ---------
            Id : ${musicaEncontrada.id}
            Nome: ${musicaEncontrada.nome}
        """.trimIndent())
    } else{
        println("Musica não existe!")
    }
}



