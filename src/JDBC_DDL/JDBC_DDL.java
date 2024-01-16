package JDBC_DDL;
import connectionPool.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_DDL {
    public static void main(String[] args) {
        createTable();
        //alterTable();
        //dropTable();

    }

    public static void createTable() {

        String sql ="""
                CREATE TABLE clientes1 (
                dni CHAR(9) NOT NULL, 
                apellido CHAR (20), 
                cp INTEGER, 
                PRIMARY KEY (dni));""";

        try (Connection c = DatabaseConnection.getConnection();
            Statement stmt = c.createStatement()){

            stmt.execute(sql);
            System.out.println("Tabla 'clientes1' creada con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void alterTable() {

        String sql ="""
                ALTER TABLE clientes1
                MODIFY cp CHAR(5)""";

        try (Connection c = DatabaseConnection.getConnection();
             Statement stmt = c.createStatement()){

            stmt.execute(sql);
            System.out.println("La columna 'cp' de la tabla 'clientes1' ha sido modificada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {

        String sql ="""
                DROP TABLE IF EXISTS clientes1""";

        try (Connection c = DatabaseConnection.getConnection();
             Statement stmt = c.createStatement()){

            boolean exito = stmt.execute(sql);
            if (exito){
                System.out.println("Se ha eliminado");
            } else {
                System.out.println("No había tabla");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
