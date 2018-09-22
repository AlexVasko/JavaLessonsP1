package com.javalesson.interfacelesson;


public class CellPhone extends Electronics implements Payable{

    public CellPhone(String vendor, String model, int quantity, float price) {
        super(vendor, model, quantity, price);
    }


    @Override
    public float calcDeliveryPrice() {
        if (getPrice() > 150) {
            return 0;
        } else {
            return 10;
        }
    }

}
