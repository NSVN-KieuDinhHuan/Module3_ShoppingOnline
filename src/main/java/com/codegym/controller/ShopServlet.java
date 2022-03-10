package com.codegym.controller;

import com.codegym.dao.shopDao;
import com.codegym.mode.Product;
import com.codegym.mode.User;
import com.codegym.service.IShopService;
import com.codegym.service.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/home")
public class ShopServlet extends HttpServlet {
    IShopService shopService;
    String username;

    public ShopServlet() {
        this.shopService = new ShopService(new shopDao());

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "logout":{
                logout(request, response);
                break;
            }case "categories": {
                showCategories(request, response);
                break;
            } default: {
                showhome(request, response);
                break;
            }
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        username=null;
        request.setAttribute("usename",username);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customerView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "singin":{
                    signIn(request,response);
                break;
            }case "register":{
                register(request,response);
                break;
            }

        }
    }



    private void signIn(HttpServletRequest request, HttpServletResponse response)  {
        username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rq;
        request.setAttribute("usename",username);
        if (username.equals("admin") && password.equals("123456")) {
            rq = request.getRequestDispatcher("/list.jsp");
//            rq.forward(request, response);
        }else if(username.equals("KIEUHUAN") && password.equals("123456")) {
             rq = request.getRequestDispatcher("/customerView.jsp");
//            rq.forward(request, response);
        }else {
            String error = "username or password wrong";
            request.setAttribute("error", error);
            rq = request.getRequestDispatcher("/signin.jsp");
//            rq.forward(request, response);
        }
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String address= request.getParameter("address");
        String email= request.getParameter("email");
        User user=new User(username,email,phone,address,password);
        shopService.register(user);
        String notification = null;
        if (shopService.register(user)) {
           notification="Sucssefull";
        }
         request.setAttribute("notify",notification);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCategories(HttpServletRequest request, HttpServletResponse response)  {
        List<Product> products = shopService.displayAll();
        String category_id = request.getParameter("category_id");
        if (category_id!=null) {
            products = shopService.findbycategory(Integer.parseInt(category_id));
        }

        request.setAttribute("usename",username);
        request.setAttribute("showAllproducts", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/categories.jsp");
        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showhome(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("usename",username);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customerView.jsp");
        try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}