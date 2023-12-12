package dao;

import Modelo.Pizza;

import java.sql.SQLException;
import java.util.List;

public interface PizzaDao {
    int add(Pizza pizza) throws SQLException;

    Pizza getById (int id) throws SQLException;

    List<Pizza> getAll() throws SQLException;

    int update(Pizza pizza) throws SQLException;

    void delete(int id) throws SQLException;


}
