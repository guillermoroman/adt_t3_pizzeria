package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/adt_t3";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
