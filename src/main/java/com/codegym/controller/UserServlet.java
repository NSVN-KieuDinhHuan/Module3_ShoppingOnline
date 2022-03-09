package com.codegym.controller;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default: {
                try {
                    showhome(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "singin":{
                try {
                    SignIn(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }case "register":{

            }

        }
    }

    private void SignIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("usename",username);
        if (username.equals("admin") && password.equals("123456")) {
            RequestDispatcher rq = request.getRequestDispatcher("/list.jsp");
            rq.forward(request, response);
        }else if(username.equals("KIEUHUAN") && password.equals("123456")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/customerView.jsp");
            dispatcher.forward(request, response);
        }else {
            String error = "username or password wrong";
            request.setAttribute("error", error);
            RequestDispatcher rq = request.getRequestDispatcher("/signin.jsp");
            rq.forward(request, response);
        }


    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

    }

        private void showhome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}