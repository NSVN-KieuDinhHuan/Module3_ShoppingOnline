package com.codegym.dao;

import com.codegym.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where role_id = 2");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                int role_id = resultSet.getInt("role_id");
                boolean status = resultSet.getBoolean("status");
                User user = new User(id,username,email,address,phone,password,role_id,status);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findByID(int id) {
        return null;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean update(int id, User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
