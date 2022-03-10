package com.codegym.service;

import com.codegym.dao.IShopDao;
import com.codegym.mode.Product;
import com.codegym.mode.User;

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
    public void Payment() {

    }
}
