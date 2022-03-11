package com.codegym.service;

import com.codegym.dao.IUserDao;
import com.codegym.dao.UserDao;
import com.codegym.model.User;

import java.util.List;

public class UserService implements IUserService{
    IUserDao userDao = new UserDao();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByID(int id) {
        return null;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean update(int id, User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
