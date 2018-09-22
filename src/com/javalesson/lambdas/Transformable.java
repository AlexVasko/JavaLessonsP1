package com.javalesson.lambdas;

@FunctionalInterface
public interface Transformable<T> {

    T transform(T t);

}
