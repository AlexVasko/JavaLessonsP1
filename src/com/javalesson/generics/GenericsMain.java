package com.javalesson.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {

    public static void main(String[] args) {
        Container<Integer> box = new Container<>(1);

        Container<String> stringBox = new Container<>("name");
        
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);


        for (Object n : numbers){
            System.out.println((Integer)n*2);
        }

//        System.out.println("Number "+(Integer)box.getObject1()*2);

    }
}
