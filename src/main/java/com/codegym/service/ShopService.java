package com.codegym.service;

import com.codegym.dao.IShopDao;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public class ShopService implements IShopService {
    private IShopDao shopDao;

    public ShopService(IShopDao shopDao) {
        this.shopDao= shopDao;
    }
    @Override
    public List<Product> displayAll() {
        return shopDao.displayAll();
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
        return shopDao.findbycategory(category_id);
    }

    @Override
    public boolean register(User user) {
        return shopDao.register(user);
    }

    @Override
    public User findUserbyEmail(String email) {
        return shopDao.findUserbyEmail(email);
    }

    @Override
    public void Payment() {

    }
}
