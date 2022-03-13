package com.codegym.service;

import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public interface IShopService {
    List<Product> displayAll();
    boolean CreateCart(Cart cart);
    boolean CreateOderDetail(OderDetail oderDetail);
    List<Product>findbycategory(int category_id);
    boolean register(User user);
    User findUserbyEmail(String email);
    List<Product> sortProduct(int sortID);
    List<Product> findProductByName(String keyword);
    Product findProductByID(int id);
    int findMaxIDCart();
}

