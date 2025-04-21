import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/base.sql";
    private static final String USER = "root"; // Remplacez par votre utilisateur
    private static final String PASSWORD = "123"; // Remplacez par votre mot de passe

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
