package com.codegym.dao;

import com.codegym.model.Category;

import java.sql.Connection;
import java.util.List;

public class CategoryDao implements ICategoryDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findByID(int id) {
        return null;
    }

    @Override
    public boolean create(Category category) {
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
