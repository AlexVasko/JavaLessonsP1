package com.javalesson.lambdas.model;

public class Circle implements Shape, AnotherShape {
    public Circle() {
        System.out.println("Creating circle");
    }

    @Override
    public double calcSquare() {
        return 1;
    }

    public double calcSomething(){
        return Shape.super.calcSomething();
    }
}
