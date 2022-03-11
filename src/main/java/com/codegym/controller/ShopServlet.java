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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/home")
public class ShopServlet extends HttpServlet {
    IShopService shopService;
    public ShopServlet() {
        this.shopService = new ShopService(new shopDao());

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        String searchContent=request.getParameter("search");
        HttpSession session = request.getSession();
        session.setAttribute("searchContent", searchContent);
        if (searchContent!=null){
            action="categories";
        }

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
            }case "contact": {
                showContact(request, response);
                break;
            } default: {
                showhome(request, response);
                break;
            }
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("username",null);
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
        HttpSession session = request.getSession();
        RequestDispatcher rq;
        if(user!=null&& user.getPassword().equals(password) && user.getRole_id()==2){
            session.setAttribute("user", user);
            request.setAttribute("username",user.getName());
            rq = request.getRequestDispatcher("/customerView.jsp");
        }else if(user!=null&& user.getPassword().equals(password) && user.getRole_id()==1){
            session.setAttribute("user", user);
            request.setAttribute("username",user.getName());
            rq = request.getRequestDispatcher("/adminTemplate/index.jsp");
        }else {
            String error = "Username or Password is wrong";
            request.setAttribute("error", error);
            rq = request.getRequestDispatcher("/signin.jsp");
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
        String notification = null;
        String username = request.getParameter("username");
        String email= request.getParameter("email");
        String address= request.getParameter("address");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        User user=new User(username,email,address,phone,password);
        Boolean checkRegister=shopService.register(user);

        if (checkRegister=true) {
           notification="Login sussesful";
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

    private void showContact(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        if (user!=null){
            request.setAttribute("username",user.getName());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contact.jsp");
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
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        String category_id = request.getParameter("category_id");
        String sorting=request.getParameter("sorting");
        String addToCart = request.getParameter("addToCart");


        String search=(String) session.getAttribute("searchContent");
        if (user!=null){
            request.setAttribute("username",user.getName());
        }
        if (category_id!=null && category_id!="") {
            products = shopService.findbycategory(Integer.parseInt(category_id));
        }
        if(sorting!=null && sorting!="0") {
            products = shopService.sortProduct(Integer.parseInt(sorting));
        }

        if (search!=null){
            products=shopService.findProductByName(search);
        }
        request.setAttribute("search",search);
        request.setAttribute("sorting",sorting);
        request.setAttribute("categorySevelet",category_id);
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
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        if (user!=null) {
            request.setAttribute("username", user.getName());
        }
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