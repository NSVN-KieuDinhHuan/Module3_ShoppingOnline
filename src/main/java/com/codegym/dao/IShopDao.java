package com.codegym.dao;

import com.codegym.mode.Category;
import com.codegym.mode.Product;
import com.codegym.mode.User;

import java.util.List;

public interface IShopDao{
    List<Product> displayAll();
    Product findByName(int id);
    List<Product> addProductIntoCart();
    List<Product>findbycategory(int category_id);
    void Payment();
    boolean register(User user);
}
