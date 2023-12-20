import Modelo.Pizza;
import dao.PizzaDao;
import dao.PizzaDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //testDao();
        testDaoLectura();
    }

    public static void testDao() {
        Pizza nuevaPizza = new Pizza("Del bambino", 5, 11, "Mozzarella, jamón");

        PizzaDao dao = new PizzaDaoImpl();

        try{
            int n = dao.add(nuevaPizza);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testDaoLectura() {
        PizzaDao dao = new PizzaDaoImpl();

        try {
            List<Pizza> pizzas = dao.getAll();
            if(pizzas.isEmpty()){
                System.out.println("No hay pizzas registradas");
            } else {
                for (Pizza pizza : pizzas) {
                    System.out.println(pizza);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
