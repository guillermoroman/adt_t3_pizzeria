package dao;

import Modelo.Pizza;
import connectionPool.DatabaseConnection;
import org.mariadb.jdbc.export.Prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PizzaDaoImpl implements PizzaDao {

    private static PizzaDaoImpl instance;

    static {
        instance = new PizzaDaoImpl();
    }

    private PizzaDaoImpl() {}

    public static PizzaDaoImpl getInstance() {
        return instance;
    }

    @Override
    public int add(Pizza pizza) throws SQLException {

        int result = 0;

        String sql = "INSERT INTO pizzas (nombre, coste, precio, ingredientes) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, pizza.getNombre());
            pstm.setDouble(2, pizza.getCoste());
            pstm.setDouble(3, pizza.getPrecio());
            pstm.setString(4, pizza.getIngredientes());

            result = pstm.executeUpdate();

        }

        return result;
    }

    @Override
    public Pizza getById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Pizza> getAll() throws SQLException {
        return null;
    }

    @Override
    public int update(Pizza pizza) throws SQLException {
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
