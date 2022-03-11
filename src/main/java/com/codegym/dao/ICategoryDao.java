package com.codegym.dao;

import com.codegym.model.Category;
import com.codegym.model.Product;

import java.util.List;

public interface ICategoryDao extends IGeneralDao<Category>{
    List<Product> getProductListByCategory(int category_id);
}
