import java.sql.*;

public class ConexionSimple {

    public static void main(String[] args) {
        pruebaSencilla();
        //prueba2();
    }
    public static void pruebaSencilla(){

        String url = "jdbc:mariadb://localhost:3306/adt_t3";
        String usuario = "root";
        String contrasena = "";

        // Establecer la conexión
        try (Connection connection = DriverManager.getConnection(url, usuario, contrasena)) {
            if (connection != null) {
                System.out.println("Conectado con éxito a la base de datos.");
                // Aquí puedes realizar operaciones con la base de datos
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
    public static void prueba2(){
        // URL de conexión a la base de datos
        String url = "jdbc:mariadb://localhost:3306/adt_t3";
        // Nombre de usuario y contraseña
        String usuario = "root";
        String contrasena = "";

        // Establecer la conexión
        try {
            Connection connection = DriverManager.getConnection(url, usuario, contrasena);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pizzas");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                System.out.println(nombre);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}