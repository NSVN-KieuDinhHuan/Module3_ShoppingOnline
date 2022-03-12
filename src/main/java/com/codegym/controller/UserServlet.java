package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import com.codegym.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
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
                int id = Integer.parseInt(request.getParameter("id"));
                User user = userService.findByID(id);
                request.setAttribute("user",user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminTemplate/user/edit.jsp");
                requestDispatcher.forward(request,response);
                break;
            }
            case "delete":{
                break;
            }
            default:{
                showUserList(request, response);
            }
        }
    }

    private void showUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.findAll();
        request.setAttribute("users",users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/user/list.jsp");
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
                int id = Integer.parseInt(request.getParameter("id"));
                boolean status = Boolean.parseBoolean(request.getParameter("status"));
                User user = new User(status);
                String message;
                boolean isUpdated = userService.update(id,user);
                if(isUpdated){
                    message = "Changed successfully";
                } else {
                    message = "Change failed";
                }
                request.setAttribute("message",message);
                request.setAttribute("isUpdated",isUpdated);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/adminTemplate/user/edit.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "delete":{
                break;
            }
        }
    }
}
