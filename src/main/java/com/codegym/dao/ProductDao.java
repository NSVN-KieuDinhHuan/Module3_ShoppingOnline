package com.codegym.dao;

import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                String image = resultSet.getString("image");
                Product product = new Product(id,name,price,description,category_id,image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findByID(int id) {
        return null;
    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like ?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nameOutput = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("category_id");
                String image = resultSet.getString("image");
                Product product = new Product(id,nameOutput,price,description,category_id,image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
