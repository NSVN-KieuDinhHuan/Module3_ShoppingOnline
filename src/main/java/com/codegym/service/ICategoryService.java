package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Product;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category>{
    List<Product> getProductListByCategory(int category_id);
}
