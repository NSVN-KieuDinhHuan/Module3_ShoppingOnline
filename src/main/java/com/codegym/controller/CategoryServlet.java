package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.User;
import com.codegym.service.CategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/categories")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "add": {
                showAddCategory(request, response);
                break;
            }
            case "delete": {
                showDeleteCategory(request, response);
                break;
            }
            case "edit": {
                showEditCategory(request, response);
                break;
            }
            case "view":{
                showViewCategory(request, response);
                break;
            }
            default: {
                showListCategory(request, response);
                break;
            }
        }
    }

    private void showViewCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        request.setAttribute("username",user.getName());
        int category_id = Integer.parseInt(request.getParameter("id"));
        List<Product> products = categoryService.getProductListByCategory(category_id);
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminTemplate/category/view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        request.setAttribute("username",user.getName());
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findByID(id);
        request.setAttribute("category", category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminTemplate/category/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        request.setAttribute("username",user.getName());
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findByID(id);
        request.setAttribute("category", category);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminTemplate/category/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showAddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        request.setAttribute("username",user.getName());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminTemplate/category/add.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        request.setAttribute("username",user.getName());
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("listCategory", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminTemplate/category/list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add": {
                addCategory(request, response);
                break;
            }
            case "delete": {
                deleteCategory(request, response);
                break;
            }
            case "edit":{
                editCategory(request, response);
                break;
            }
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category(id, name);
        categoryService.update(id, category);
        response.sendRedirect("/categories");
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        response.sendRedirect("/categories");
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        Category category = new Category(name);
        categoryService.create(category);
        request.setAttribute("message", "Adding Successful!!!");
//        response.sendRedirect("/categories");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminTemplate/category/add.jsp");
        requestDispatcher.forward(request, response);
    }
}
