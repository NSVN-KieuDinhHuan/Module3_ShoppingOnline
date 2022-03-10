package com.codegym.dao;

import com.codegym.model.Product;
import com.codegym.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class shopDao implements IShopDao {
    private Connection connection = DBConnection.getConnection();
    public static final String SQL_SELECT_ALL_PRODUCT = "SELECT * FROM product;";
    public static final String SQL_FIND_PRODUCT_BY_CATEGORY = "SELECT * FROM product Where category_id=?;";
    public static final String SQL_ADD_USER = "INSERT INTO user(username, email,address, phone, password, role_id,status) VALUES (?,?,?,?,?,1,true);";
    public static final String SQL_FIND_USER_BY_EMAIL = "SELECT * FROM user Where email=?;";

    @Override
    public List<Product> displayAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                String productImage=resultSet.getString("image");
                Product product = new Product(id, name, price, description,categoryId,productImage);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findByName(int id) {
        return null;
    }

    @Override
    public List<Product> addProductIntoCart() {
        return null;
    }

    @Override
    public List<Product> findbycategory(int category_id) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PRODUCT_BY_CATEGORY);
            preparedStatement.setInt(1, category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String productImage = resultSet.getString("image");
                products.add( new Product(id, name, price, description,category_id,productImage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public User findUserbyEmail(String email) {
        User user=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String password = resultSet.getString("password");
                int role_id = resultSet.getInt("role_id");
                boolean staus = resultSet.getBoolean("role_id");
                user = new User(id, name, email, address, phone, password,role_id,staus);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public void Payment() {

    }

    @Override
    public boolean register(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getPassword());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    //Them san pham vao gio hang
//
}
