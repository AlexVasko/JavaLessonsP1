package com.javalesson.oop;


public class Main {

    public static void main(String[] args) {

        System.out.println("Dog's count "+ Dog.getDogsCount());

        Dog lab = new Dog();
        lab.setName("Charley");
        lab.setBreed("Lab");
        lab.setSize(Size.AVERAGE);
        lab.bite();

        Dog sheppard = new Dog();
        sheppard.setName("Mike");
        sheppard.setBreed("Sheppard");
        sheppard.setSize(Size.BIG);
        sheppard.bite();


        Dog doberman = new Dog();
        doberman.setName("Jack");
        doberman.setBreed("Doberman");
        doberman.setSize(Size.BIG);
        doberman.bite();


        Size s = Size.SMALL;
        Size s1 = Size.valueOf("BIG");
//        System.out.println(s1);
        Size[] values = Size.values();
        for(int i=0; i<values.length; i++){
            System.out.println(values[i]);
        }


    }

}
