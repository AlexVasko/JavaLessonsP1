package com.javalesson.interfacelesson;


public class Launcher {

    public static void main(String[] args) {

        Deliverable[] goods = new Deliverable[3];
        goods[0] = new Pizza("Neapolitana", 1, 20, Size.M);
        goods[1] = new CellPhone("Smsung", "EX56", 1, 100);
        goods[2] = new Fridge("LG", "XX5112", 1, 200);

        process(goods);

        goods[0].calcPayment();

    }

    private static void process(Deliverable[] del) {
        for (Deliverable d : del) {
            System.out.println("Delivery price " +d.getClass().getSimpleName()+ " is " + d.calcDeliveryPrice());
            System.out.println("Total payment " +d.getClass().getSimpleName()+ " is " + d.calcPayment());

        }

    }

}
