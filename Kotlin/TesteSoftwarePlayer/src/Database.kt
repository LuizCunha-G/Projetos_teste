import java.sql.Connection
import java.sql.DriverManager

object Database {
    private const val URL = "jdbc:mysql://127.0.0.1:3306/SoftPlay"
    private const val USER = "Gustavo"
    private const val PASSWORD = "sptech"

    fun connect(): Connection {
        return DriverManager.getConnection(URL, USER, PASSWORD)
    }
}
