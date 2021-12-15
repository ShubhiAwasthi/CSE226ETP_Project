package com.example.shoppingapp.Models;

public class OrdersModel {
    int product_image;
    String product_name,order_number,product_price;

    public OrdersModel() {
        this.product_image = product_image;
        this.product_name = product_name;
        this.order_number = order_number;
        this.product_price = product_price;
    }

    public int getProduct_image() {
        return product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getOrder_number() {
        return order_number;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}