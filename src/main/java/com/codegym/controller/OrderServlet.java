package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/orders")
public class OrderServlet extends HttpServlet {
    OrderService orderService = new OrderService();
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
            case "create":{
                break;
            }
            case "edit":{
                break;
            }
            case "delete":{
                break;
            }
            default:{
                List<Cart> orders = orderService.findAll();
                request.setAttribute("orders",orders);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/order/list.jsp");
                dispatcher.forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":{
                break;
            }
            case "edit":{
                break;
            }
            case "delete":{
                break;
            }
        }
    }
}
