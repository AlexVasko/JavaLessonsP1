package com.javalesson.generics;

public class MyBox<X> {


    X someField;
   public <T> MyBox(T param){
       System.out.println(param.getClass().getSimpleName());
   }

   public static <U> U returnValue(U param){
       return param;
   }
}
