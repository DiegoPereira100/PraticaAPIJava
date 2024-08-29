import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class BD {
    public static Connection connection() throws SQLException{
        var jdbcURL = "jdbc:mysql://localhost:3306/db_buscaCep";
        var user = "root";
        var password = "";
        return DriverManager.getConnection(jdbcURL, user, password);
    }
}