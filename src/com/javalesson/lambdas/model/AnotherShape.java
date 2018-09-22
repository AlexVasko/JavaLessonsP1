package com.javalesson.lambdas.model;

public interface AnotherShape {

    default double calcSomething(){
        return 2;
    }
}
