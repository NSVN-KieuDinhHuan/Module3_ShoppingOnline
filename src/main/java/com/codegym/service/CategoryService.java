package com.codegym.service;

import com.codegym.dao.CategoryDao;
import com.codegym.dao.ICategoryDao;
import com.codegym.model.Category;
import com.codegym.model.Product;

import java.util.List;

public class CategoryService implements ICategoryService{
    ICategoryDao categoryDao = new CategoryDao();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
    @Override
    public Category findByID(int id) {
        return categoryDao.findByID(id);
    }

    @Override
    public boolean create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public boolean update(int id, Category category) {
        return categoryDao.update(id,category);
    }

    @Override
    public boolean delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public List<Product> getProductListByCategory(int category_id) {
        return categoryDao.getProductListByCategory(category_id);
    }
}
