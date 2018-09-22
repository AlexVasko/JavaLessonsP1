package com.javalesson.interfaces;

public interface Pricable extends Deliverable, Orderable {

    default int calcPrice(){
        return calcOrderPrice() + calcDeliveryPrice();
    }
 }
