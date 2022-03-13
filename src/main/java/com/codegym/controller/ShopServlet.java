package com.codegym.controller;

import com.codegym.dao.shopDao;
import com.codegym.model.Cart;
import com.codegym.model.OderDetail;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.IShopService;
import com.codegym.service.OrderService;
import com.codegym.service.ShopService;
import com.codegym.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/home")
public class ShopServlet extends HttpServlet {
    IShopService shopService;
    int orderDetailID;
    Cart cart;
    List<OderDetail> oderDetails;
    UserService userService = new UserService();
    OrderService orderService = new OrderService();
    int quantity=1;
    public ShopServlet() {
        this.shopService = new ShopService(new shopDao());
        oderDetails=new ArrayList<>();
        orderDetailID=1;
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
                quantity=1;
                showCategories(request, response);
                break;
            }case "contact": {
                showContact(request, response);
                break;
            }case "detailProduct": {
                detailProduct(request, response);
                break;
            }case "orderDetail": {
                OrderDetail(request, response);
                break;
            }case "payment": {
                Payment(request, response);
                break;
             }case "history": {
                PurchaseHistory(request, response);
            break;
            }case "profile": {
                profile(request, response);
                break;

             } default: {
                showhome(request, response);
                break;
            }
        }
    }

    private void profile(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        if (user!=null){
            request.setAttribute("user",user);

        }
        request.setAttribute("oderDetails",oderDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

       private void PurchaseHistory(HttpServletRequest request, HttpServletResponse response) {
           HttpSession session = request.getSession();
           User user =(User) session.getAttribute("user");
           if (user!=null){
               request.setAttribute("username",user.getName());
               List<OderDetail> purchaseHistory =shopService.PurchaseHistory(user.getId());
               request.setAttribute("purchaseHistory",purchaseHistory);
               request.setAttribute("shopService",shopService);
               request.setAttribute("oderDetails",oderDetails);
               RequestDispatcher dispatcher = request.getRequestDispatcher("/purchaseHistoryView.jsp");
           try {
               dispatcher.forward(request, response);
           } catch (ServletException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
           }


       }

        private void detailProduct(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        if (user!=null){
            request.setAttribute("username",user.getName());
        }
        String incr=request.getParameter("quantity");
        if(incr!=null) {
            quantity = quantity + Integer.parseInt(incr);
        }
        Product product=null;
        String add=request.getParameter("add");
        String productID=request.getParameter("id");
        if (productID!=null) {
            product=shopService.findProductByID(Integer.parseInt(productID));
            request.setAttribute("product",product);
        }

        if (product!=null && add!=null) {
            OderDetail oderDetail=new OderDetail(orderDetailID,product.getId(),quantity);
            oderDetails.add(oderDetail);
            orderDetailID=orderDetailID+1;
        }
        request.setAttribute("quantity",quantity);
        request.setAttribute("oderDetails",oderDetails);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/single.jsp");
        if(add!=null && add.equals("yes1")) {
              dispatcher = request.getRequestDispatcher("/home?action=categories");
          }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Payment(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        request.setAttribute("oderDetails",oderDetails);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher;
        if (user!=null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            int cart_id=shopService.findMaxIDCart()+1;
            cart=new Cart(cart_id,user.getId(),dtf.format(now));
            shopService.CreateCart(cart);
           for (int i = 0; i <oderDetails.size() ; i++) {
               oderDetails.get(i).setCart_id(cart.getId());
               shopService.CreateOderDetail(oderDetails.get(i));
           }
            oderDetails.clear();
          dispatcher = request.getRequestDispatcher("/payment.jsp");
        }else {
             dispatcher = request.getRequestDispatcher("/signin.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void OrderDetail(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        if (user!=null){
            request.setAttribute("user",user);
        }
        String oderDetailId=request.getParameter("id");
        if (oderDetailId!=null) {
            for (int i = 0; i < oderDetails.size(); i++) {
                if (oderDetails.get(i).getId()==Integer.parseInt(oderDetailId)){
                    oderDetails.remove(i);
                }
            }



        }

        request.setAttribute("oderDetails",oderDetails);
        request.setAttribute("shopService",shopService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/oderDetailView.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
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
        request.setAttribute("oderDetails",oderDetails);
        User user=shopService.findUserbyEmail(email);
        HttpSession session = request.getSession();
        RequestDispatcher rq;
        if(user!=null&& user.getPassword().equals(password) && user.getRole_id()==2 && user.getStatus()){
            session.setAttribute("user", user);
            request.setAttribute("username",user.getName());
            rq = request.getRequestDispatcher("/customerView.jsp");
        }else if(user!=null&& user.getPassword().equals(password) && user.getRole_id()==1){
            session.setAttribute("user", user);
            request.setAttribute("username",user.getName());
            int countUser = userService.countUser();
            request.setAttribute("countUser",countUser);
            int countOrder = orderService.countOrder();
            request.setAttribute("countOrder",countOrder);
            int totalProductQuantity = orderService.totalQuantityOfProduct();
            request.setAttribute("totalProductQuantity",totalProductQuantity);
            Double totalAvenue = orderService.totalRevenue();
            request.setAttribute("totalAvenue",totalAvenue);
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
           notification="Register sussesful !";
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
        request.setAttribute("oderDetails",oderDetails);
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
        session.setAttribute("allProduct",products);

        User user =(User) session.getAttribute("user");
        String category_id = request.getParameter("category_id");
        String sorting=request.getParameter("sorting");
        request.setAttribute("oderDetails",oderDetails);
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
        List<Product> bestseller=shopService.bestSeller();
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        request.setAttribute("oderDetails",oderDetails);
        request.setAttribute("bestseller",bestseller);
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