package com.javalesson.interfacelesson;


import java.io.Serializable;

public class Pizza implements Deliverable, Serializable {

    private String name;
    private int quantity;
    private float price;
    private Size size;

    public Pizza(String name, int quantity, float price, Size size) {
        this.name = name;
        this.size = size;
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be <=0");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be > 0");
        }
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public float calcDeliveryPrice() {
        if (size == Size.XL || quantity > 1) {
            return 0;
        } else {
            return 5;
        }

    }

    @Override
    public float calcPayment() {
        return price + calcDeliveryPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be <=0");
        }
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be > 0");
        }
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
