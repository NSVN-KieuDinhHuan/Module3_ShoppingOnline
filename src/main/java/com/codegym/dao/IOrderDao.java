package com.codegym.dao;

import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
import com.codegym.model.User;

import java.util.List;

public interface IOrderDao extends IGeneralDao<Cart>{
    List<User> findAllUserHavingOrder();
    List<OderDetail> findOrderDetailByOrderID(int order_id);
    int countOrder();
    List<OderDetail> findAllOrderDetails();
    int totalQuantityOfProduct();
}
