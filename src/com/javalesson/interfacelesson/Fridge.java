package com.javalesson.interfacelesson;


public class Fridge extends Electronics implements Payable {

    public Fridge(String vendor, String model, int quantity, float price) {
        super(vendor, model, quantity, price);
    }


    @Override
    public float calcDeliveryPrice() {
        if (getPrice() > 300) {
            return 0;
        } else {
            return 50;
        }
    }

}
