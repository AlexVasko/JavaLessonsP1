package com.javalesson.lambdas.model;

public class Square implements Shape {
    public Square() {
        System.out.println("Creating square");
    }

    @Override
    public double calcSquare() {
        return 2;
    }
}
