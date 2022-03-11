package com.codegym.controller;

import com.codegym.model.Product;
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "view": {
                break;
            }
            default:{
                showListProduct(request, response);
            }
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        if(q == null){
            List<Product> products = productService.findAll();
            request.setAttribute("products",products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/product/list.jsp");
            dispatcher.forward(request, response);
        } else {
            List<Product> products = productService.searchByName(q);
            request.setAttribute("products",products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/product/list.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
