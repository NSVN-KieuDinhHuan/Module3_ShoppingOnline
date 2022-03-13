package com.codegym.service;

import com.codegym.model.Cart;
import com.codegym.model.User;

import java.util.List;

public interface IOrderService extends IGeneralService<Cart>{
    List<User> findAllUserHavingOrder();
}
