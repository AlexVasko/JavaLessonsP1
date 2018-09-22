package com.javalesson.interfacelesson;


public  abstract class Electronics implements Deliverable{

    private String vendor;
    private String model;
    private int quantity;
    private float price;

    public Electronics(String vendor, String model, int quantity, float price) {
        this.vendor = vendor;
        this.model = model;
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be > 0");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be > 0");
        }
        this.quantity = quantity;
        this.price = price;

    }

    @Override
    public float calcPayment() {
        return getPrice() + calcDeliveryPrice();
    }
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be > 0");
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
}
