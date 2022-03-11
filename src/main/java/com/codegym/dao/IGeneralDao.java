package com.codegym.dao;

import java.util.List;

public interface IGeneralDao<T>{
    List<T> findAll();
    T findByID(int id);
    boolean create(T t);
    boolean update(int id, T t);
    boolean delete(int id);
}
