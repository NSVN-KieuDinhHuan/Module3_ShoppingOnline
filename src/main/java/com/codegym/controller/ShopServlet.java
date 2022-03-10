package com.codegym.controller;

import com.codegym.dao.shopDao;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.IShopService;
import com.codegym.service.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        String email=request.getParameter("email");
        String password = request.getParameter("password");
        User user=shopService.findUserbyEmail(email);
        RequestDispatcher rq;
        if(user!=null&& user.getPassword().equals(password) && user.getRole_id()==2){
            username = user.getName();
            rq = request.getRequestDispatcher("/customerView.jsp");

        }else if(user!=null&& user.getPassword().equals(password) && user.getRole_id()==1){
            username = user.getName();
            rq = request.getRequestDispatcher("/adminTemplate/index.jsp");
        }else {
            String error = "Username or Password is wrong";
            request.setAttribute("error", error);
            rq = request.getRequestDispatcher("/signin.jsp");
        }
        request.setAttribute("usename",username);

        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String notification = null;
        String username = request.getParameter("username");
        String email= request.getParameter("email");
        String address= request.getParameter("address");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        User user=new User(username,email,address,phone,password);
         Boolean checkRegister=shopService.register(user);

        if (checkRegister=true) {
           notification="Da Dang ky thanh cong";
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
        String sorting=request.getParameter("sorting");
        if (category_id!=null && category_id!="") {
            products = shopService.findbycategory(Integer.parseInt(category_id));
        }
        if(sorting!=null) {
           if(sorting.equals("1")) {
               products = shopService.sortProductByPrice();
           }
        }

        request.setAttribute("categorySevelet",category_id);
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