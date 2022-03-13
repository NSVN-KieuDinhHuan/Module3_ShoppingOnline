package com.codegym.model;

public class OderDetail {
    int id;
    int cart_id;
    int product_id;
    int quantity;
    String productName;
    Double price;
    Double amountForEachProduct;
    Double amount;

    public OderDetail(int quantity, String productName, Double price, Double amountForEachProduct) {
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
        this.amountForEachProduct = amountForEachProduct;
    }

    public OderDetail(int id, int cart_id, int product_id, int quantity, String productName, Double price) {
        this.id = id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public OderDetail(int id, int cart_id, int product_id, int quantity, String productName, Double price, Double amountForEachProduct, Double amount) {
        this.id = id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
        this.amountForEachProduct = amountForEachProduct;
        this.amount = amount;
    }

    public OderDetail(int id, int cart_id, int product_id, int quantity, String productName, Double price, Double amount) {
        this.id = id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public OderDetail(int id, int cart_id, int product_id, int quantity) {
        this.id = id;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OderDetail(int id, int product_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OderDetail(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OderDetail() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getAmountForEachProduct() {
        return amountForEachProduct;
    }

    public void setAmountForEachProduct(Double amountForEachProduct) {
        this.amountForEachProduct = amountForEachProduct;
    }
}
