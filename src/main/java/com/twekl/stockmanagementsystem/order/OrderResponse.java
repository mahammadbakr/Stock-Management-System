package com.twekl.stockmanagementsystem.order;

import com.twekl.stockmanagementsystem.vendor.Vendor;

public class OrderResponse {

    private String name;
    private String itemName;

    public OrderResponse( ) {
    }

    public OrderResponse(String name, String itemName) {
        this.name = name;
        this.itemName = itemName;
    }

    private int price;

    public OrderResponse(String name, String itemName,int price) {
        this.name = name;
        this.itemName = itemName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
