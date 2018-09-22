package com.javalesson.collections.autoboxing;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(Integer.valueOf(1));


        Integer integ = 56;
        int n = integ.intValue();
        Double doub = 56.567;
        double d = doub.doubleValue();



        String[] colors = {"yellow", "green","blue"};

        LinkedList<String> ll = new LinkedList<>(Arrays.asList(colors));
        ll.add("black");

        colors = ll.toArray(new String[ll.size()]);

        for (int i = 0; i<colors.length; i++){
            System.out.println(colors[i]);
        }
    }
}
