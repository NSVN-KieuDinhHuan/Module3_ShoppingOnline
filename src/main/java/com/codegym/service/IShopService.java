package com.codegym.service;

import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public interface IShopService {
    List<Product> displayAll();
    List<Product>bestSeller();
    List<Product>findbycategory(int category_id);
    User findUserbyEmail(String email);
    List<Product> sortProduct(int sortID);
    List<Product> findProductByName(String keyword);
    Product findProductByID(int id);
    int findMaxIDCart();
    List<OderDetail> PurchaseHistory(int user_id);
    boolean CreateOderDetail(OderDetail oderDetail);
    boolean CreateCart(Cart cart);
    boolean register(User user);
    Cart findCartbyID(int cart_id);
}

