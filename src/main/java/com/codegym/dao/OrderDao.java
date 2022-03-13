package com.codegym.dao;

import com.codegym.model.Cart;
import com.codegym.model.User;

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
            PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                    "from cart join user u on cart.user_id = u.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String orderDate = resultSet.getString("orderDate");
                String name = resultSet.getString("username");
                Cart cart = new Cart(id,user_id,orderDate,name);
                orders.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
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

    @Override
    public List<User> findAllUserHavingOrder() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                    "from cart join user u on cart.user_id = u.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("username");
                User user = new User(name);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
