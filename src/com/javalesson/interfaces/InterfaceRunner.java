package com.javalesson.interfaces;

public class InterfaceRunner {

    public static void main(String[] args) {
        Pricable pizza = new Pizza("Neapolitana", 1, 20, Size.L);
        Pricable phone = new CellPhone("Motorola", "XT1575", 1, 250);
        Pricable fridge = new Fridge("LG","E9090", 1, 300);



        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);

    }

    private static void printDeliveryPrice(Pricable del){
        System.out.println("Delivery prise "+del.calcDeliveryPrice());
        System.out.println("Order prise "+del.calcOrderPrice());
    }

}
