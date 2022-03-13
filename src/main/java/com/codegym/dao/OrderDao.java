package com.codegym.dao;

import com.codegym.model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements IOrderDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Cart> findAll() {
        List<Cart> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cart");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String orderDate = resultSet.getString("orderDate");
                Cart cart = new Cart(id,user_id,orderDate);
                orders.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cart findByID(int id) {
        return null;
    }

    @Override
    public boolean create(Cart cart) {
        return false;
    }

    @Override
    public boolean update(int id, Cart cart) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
