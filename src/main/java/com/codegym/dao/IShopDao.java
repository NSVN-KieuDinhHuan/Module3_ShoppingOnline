package com.codegym.dao;

import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
import com.codegym.model.Product;
import com.codegym.model.User;

import java.util.List;

public interface IShopDao{
    Product findProductByID(int id);

    boolean CreateOderDetail(OderDetail oderDetail);
    User findUserbyEmail(String email);
    int findMaxIDCart();
    List<Product> displayAll();
    List<Product>findbycategory(int category_id);
    List<Product> sortProduct(int sortID);
    List<Product>bestSeller();
    List<OderDetail> PurchaseHistory(int user_id);
    List<Product> findProductByName(String keyword);
    boolean register(User user);
    boolean CreateCart(Cart cart);
    Cart findCartbyID(int cart_id);
}
