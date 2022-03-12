package com.codegym.dao;

import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public interface IShopDao{
    List<Product> displayAll();
    Product findProductByID(int id);
    boolean CreateCart(Cart cart);
    boolean CreateOderDetail(OderDetail oderDetail);
    List<Product>findbycategory(int category_id);
    User findUserbyEmail(String email);
    List<Product> sortProduct(int sortID);
    List<Product> findProductByName(String keyword);

    void Payment();
    boolean register(User user);
}
