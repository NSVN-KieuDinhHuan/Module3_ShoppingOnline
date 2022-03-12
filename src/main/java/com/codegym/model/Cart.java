package com.codegym.model;

public class Cart {
   private int id;
   private  int user_id;
   private String orderDate;

    public Cart() {
    }

    public Cart(int user_id, String orderDate) {
        this.user_id = user_id;
        this.orderDate = orderDate;
    }

    public Cart(int id, int user_id, String orderDate) {
        this.id = id;
        this.user_id = user_id;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
