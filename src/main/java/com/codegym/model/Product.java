package com.codegym.model;

public class Product {
    private int id;
    protected String name;
    protected double price;
    protected String description;
    protected int category_id;
    protected String productImage;

    public Product() {
    }

    public Product(String name, double price, String description, int category_id, String productImage) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
        this.productImage = productImage;
    }

    public Product(int id, String name, double price, String description, int category_id, String productImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
        this.productImage = productImage;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
