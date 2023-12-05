import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.sql.*;

public class ConexionSimple {

    public static void main(String[] args) {
        //pruebaSencilla();
        //imprimirPizzas();
        createPizza();
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

    public static void imprimirPizzas(){

        String url = "jdbc:mariadb://localhost:3306/adt_t3";
        String usuario = "root";
        String contrasena = "";

        // Establecer la conexión
        try {
            Connection connection = DriverManager.getConnection(url, usuario, contrasena);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT nombre FROM pizzas");

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                System.out.println(nombre);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
    public static void createPizza(){
        try (Connection conn = DatabaseConnection.getConnection()){
            String nombre = "Del Chef";
            double coste = 6.0;
            double precio = 14.0;
            String ingredientes = "Tomate, Mozarella, Cecina, Queso de Cabra, Nueces, Cebolla Caramelizada";

            String sql = "INSERT INTO pizzas (nombre, coste, precio, ingredientes) VALUES ('"
                    + nombre + "', "
                    + coste + ", "
                    + precio + ", '"
                    + ingredientes + "')";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Pizza añadida a la base de datos");

        } catch (SQLException e){
            System.out.println("Problema al acceder a la base de datos");
        }
    }



}

