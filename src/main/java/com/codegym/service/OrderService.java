package com.codegym.service;

import com.codegym.dao.IOrderDao;
import com.codegym.dao.OrderDao;
import com.codegym.model.Cart;

import java.util.List;

public class OrderService implements IOrderService{
    IOrderDao orderDao = new OrderDao();
    @Override
    public List<Cart> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Cart findByID(int id) {
        return orderDao.findByID(id);
    }

    @Override
    public boolean create(Cart cart) {
        return orderDao.create(cart);
    }

    @Override
    public boolean update(int id, Cart cart) {
        return orderDao.update(id,cart);
    }

    @Override
    public boolean delete(int id) {
        return orderDao.delete(id);
    }
}
