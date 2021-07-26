package com.example.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Item {

    private Integer itemId;

    private String itemName;

    private double itemPrice;

    private boolean isAvailable;

    public Item(String itemName, double itemPrice, boolean isAvailable) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isAvailable = isAvailable;
    }

    public Item() {
    }

    public Item(Integer itemId, String itemName, double itemPrice, boolean isAvailable) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isAvailable = isAvailable;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}