package com.codegym.service;

import com.codegym.dao.IProductDao;
import com.codegym.dao.ProductDao;
import com.codegym.model.Product;

import java.util.List;

public class ProductService implements IProductService{
    IProductDao productDao = new ProductDao();

    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    public ProductService() {
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findByID(int id) {
        return productDao.findByID(id);
    }

    @Override
    public boolean create(Product product) {
        return productDao.create(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDao.update(id,product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }


    @Override
    public List<Product> searchByName(String name) {
        name = "%"+name+"%";
        return productDao.searchByName(name);
    }
}