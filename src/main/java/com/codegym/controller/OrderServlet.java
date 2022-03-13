package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.CategoryService;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Or;

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
                int order_id = Integer.parseInt(request.getParameter("id"));
                List<OderDetail> oderDetails = orderService.findOrderDetailByOrderID(order_id);
                request.setAttribute("orderDetails",oderDetails);
                Double totalAmount = 0.0;
                for (int i = 0; i < oderDetails.size(); i++) {
                    totalAmount += oderDetails.get(i).getPrice() * oderDetails.get(i).getQuantity();
                }
                request.setAttribute("totalAmount",totalAmount);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/order/view.jsp");
                dispatcher.forward(request,response);
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
                showListOrder(request, response);
            }
        }
    }

    private void showListOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cart> orders = orderService.findAll();
        request.setAttribute("orders",orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/order/list.jsp");
        dispatcher.forward(request, response);
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
