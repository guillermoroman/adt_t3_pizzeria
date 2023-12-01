import javax.xml.transform.Result;
import java.sql.*;

public class ConexionSimple {

    public static void main(String[] args) {
        //pruebaSencilla();
        //imprimirPizzas();
        imprimirMenu();
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
            Statement statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pizzas");

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

    public static void imprimirMenu(){
        String url = "jdbc:mariadb://localhost:3306/adt_t3";
        String usuario = "root";
        String contrasena = "";

        // Establecer la conexión
        try {
            Connection connection = DriverManager.getConnection(url, usuario, contrasena);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT nombre, precio, ingredientes FROM pizzas");

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                Double precio = resultSet.getDouble("precio");
                String ingredientes = resultSet.getString("ingredientes");

                System.out.println(nombre + "........"+ precio);
                System.out.println(ingredientes);
                System.out.println();
            }
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}

//Listar todas las pizzas en formato menu.
/*
[Nombre de pizza]......[precio]
[Ingredientes]

[Nombre de pizza]



 */