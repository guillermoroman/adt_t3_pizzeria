package dao;

import Modelo.Pizza;
import connectionPool.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDaoImpl implements PizzaDao{
    @Override
    public int add(Pizza pizza) throws SQLException {
        int result =0;

        String sql = "INSERT INTO pizzas (nombre, coste, precio, ingredientes) "
                + " VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)){

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
        String sql = " SELECT * FROM pizzas";
        List<Pizza> result = new ArrayList<Pizza>();

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery()){

            Pizza p;
                while (rs.next()){
                    p = new Pizza();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setCoste(rs.getDouble("coste"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setIngredientes(rs.getString("ingredientes"));

                    result.add(p);
                }
        }
        return result;
    }

    @Override
    public int update(Pizza pizza) throws SQLException {
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
