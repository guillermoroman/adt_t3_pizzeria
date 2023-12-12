import Modelo.Pizza;
import dao.PizzaDao;
import dao.PizzaDaoImpl;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        testDao();
    }

    public static void testDao(){
        PizzaDao dao = PizzaDaoImpl.getInstance();

        Pizza nuevaPizza = new Pizza("Del Chef", 10, 16, "Cecina, queso de cabra, cebolla caramelizada");

        try {
            int n = dao.add(nuevaPizza);
            System.out.println("El número de registros insertados es: " + n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
