package com.javalesson.exceptionhandling;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingMain {
    private static int SIZE = 10;

    public static void main(String[] args) {

        try {
            doEverything();
        } catch (ArrayIndexOutOfBoundsException e) {
           throw e;
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown");
            e.printStackTrace();
            Throwable[] suppressed = e.getSuppressed();
            System.out.println("==========================");
            for (int i = 0; i <= suppressed.length; i++) {
                System.out.println("Suppressed " + suppressed[i]);
            }
        }
    }

    private static void doEverything() throws ArrayIndexOutOfBoundsException, NullPointerException{
        Scanner scanner = new Scanner(System.in);
        String filename = "out.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename)); BufferedReader br = new BufferedReader(new FileReader(filename))) {
            System.out.println("Please enter first element");
            int first = scanner.nextInt();
            System.out.println("Please enter last element");
            int last = scanner.nextInt();
            int[] intArray;
            if (first < last) {
                intArray = populateArray(first, last);
            } else {
                intArray = populateArray(last, first);
            }
            int elem = intArray[SIZE];

            for (int i = 0; i < intArray.length; i++) {
                writer.println("Next element " + intArray[i]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Exception : " + e);
            scanner.nextLine();
            System.out.println("Only integer values allowed. Denominator should not be zero");
        } catch (IOException e) {
            System.out.println("File does not exist " + e);
        } catch (IndexOutOfBoundsException e){
            throw new InvalidInputException("Difference between upper and lower bound should be > "+SIZE,e);
        }

        finally {
            System.out.println("Finally block called");
        }
    }

    private static int[] populateArray(int first, int last) throws ArrayIndexOutOfBoundsException {
        int size = last - first;
        int[] myArray = new int[size];
        for (int i = 0; i < size; i++) {
            myArray[i] = first;
            first++;
        }
        return myArray;
    }

}
