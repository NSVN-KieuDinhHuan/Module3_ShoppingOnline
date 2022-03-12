package com.codegym.model;

public class User {
    private int id;
    private  String name;
    private  String email;
    private  String address;
    private  String phone;
    private  String Password;
    private int role_id;
    private boolean status;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User(boolean status) {
        this.status = status;
    }

    public User(String name, String email, String address, String phone, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        Password = password;
    }

    public User(String name, String email, String address, String phone, String password, boolean status) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        Password = password;
        this.status = status;
    }

    public User(int id, String name, String email, String address, String phone, String password, int role_id, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        Password = password;
        this.role_id = role_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public boolean getStatus(){
        return status;
    }
}
