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
        return userDao.findByID(id);
    }

    @Override
    public boolean create(User user) {
        return userDao.create(user);
    }

    @Override
    public boolean update(int id, User user) {
        return userDao.update(id,user);
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int countUser() {
        return userDao.countUser();
    }
}
