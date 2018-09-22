package com.javalesson.collections.arrays;


import java.util.Scanner;

public class ArrayLauncher {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myArray = new int[8];
        System.out.println("Please enter 8 array elements");

        for (int i=0; i<myArray.length; i++){
            myArray[i] = scanner.nextInt();
        }
        int[] sorterdArray = sort(myArray);

        for (int i =0; i<sorterdArray.length; i++){
            System.out.println("Element #"+i+" ="+myArray[i]);

        }
    }

        private static int[] sort(int[] array){
            for(int i=0; i<array.length; i++){
                for (int y =0; y<array.length-1; y++){
                    if(array[y]>array[y+1]){
                        int temp = array[y];
                        array[y] = array [y+1];
                        array[y+1] = temp;
                    }
                }
            }
            return array;

//            10, 5, 16, 4
//            5, 10, 16, 4
//            5, 10, 4, 16
//            5, 4, 10, 16
//

        }
}


