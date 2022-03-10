package com.codegym.service;

import com.codegym.mode.Product;
import com.codegym.mode.User;

import java.util.List;

public interface IShopService {
    List<Product> displayAll();
    Product findByName(int id);
    List<Product> addProductIntoCart();
    List<Product>findbycategory(int category_id);
    boolean register(User user);
    void Payment();
}

