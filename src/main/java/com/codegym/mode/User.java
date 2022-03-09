package com.codegym.mode;

public class User {
    protected int id;
    protected String name;
    protected String DateOfBirth;
    protected String email;
    protected String phone;
    protected String address;
    protected String Password;

    public User() {
    }

    public User(int id, String name, String dateOfBirth, String email, String phone, String address, String password) {
        this.id = id;
        this.name = name;
        DateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
        this.address = address;
        Password = password;
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

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
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
}
