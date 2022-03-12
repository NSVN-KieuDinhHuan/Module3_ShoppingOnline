package com.codegym.service;

import com.codegym.dao.IShopDao;
import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
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
    public boolean CreateCart(Cart cart) {
        return shopDao.CreateCart(cart);
    }

    @Override
    public boolean CreateOderDetail(OderDetail oderDetail) {
        return shopDao.CreateOderDetail(oderDetail);
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
    public List<Product> sortProduct(int sortID) {
        return shopDao.sortProduct(sortID);
    }

    @Override
    public List<Product> findProductByName(String keyword) {
        keyword="%"+keyword+"%";
        return shopDao.findProductByName(keyword);
    }

    @Override
    public Product findProductByID(int id) {
        return shopDao.findProductByID(id);
    }


    @Override
    public void Payment() {

    }
}
