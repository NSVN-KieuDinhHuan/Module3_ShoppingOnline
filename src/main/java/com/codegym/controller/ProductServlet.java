package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "view": {
                showProductDetail(request, response);
                break;
            }
            case "create":{
                List<Category> categories = categoryService.findAll();
                request.setAttribute("categories",categories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/product/create.jsp");
                dispatcher.forward(request,response);
                break;
            }
            default:{
                showListProduct(request, response);
            }
        }
    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findByID(id);
        Category category = categoryService.findByID(product.getCategory_id());
        request.setAttribute("product",product);
        request.setAttribute("category",category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/product/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        if (q == null) {
            List<Product> products = productService.findAll();
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/product/list.jsp");
            dispatcher.forward(request, response);
        } else {
            List<Product> products = productService.searchByName(q);
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/product/list.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
