package com.javalesson.exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptionHandlingMain {
    public static void main(String[] args) {

        try {
            doEverything();
        } catch (InvalidInputParamException e) {
            System.out.println("InvalidInputParamException");
            e.printStackTrace();
        }
    }

    private static void doEverything() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            try (PrintWriter writer = new PrintWriter(new FileWriter("out.txt"))) {
                System.out.println("Please enter numerator");
                int numerator = scanner.nextInt();
                System.out.println("Please enter denominator");
                int denominator = scanner.nextInt();
                System.out.println(divide(numerator, denominator));
//                int[] intArray = new int[1];
//                int i = intArray[2];
                writer.println("Result = " + divide(numerator, denominator));
                continueLoop = false;
            } catch (ArithmeticException | InputMismatchException e) {
                System.out.println("Exception : " + e);
                scanner.nextLine();
                System.out.println("Only integer non-zero parameters allowed");
            } catch (IOException e) {
                System.out.println("Unable to open file");
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("All Exceptions here");
                throw new InvalidInputParamException("Index out of bound. thrown in doEverything " + e);
            } finally {
                System.out.println("Finally block called");
            }
            System.out.println("Try catch block finished");
        } while (continueLoop);
    }

    private static int divide(int numerator, int denominator) throws ArithmeticException, NullPointerException {
        return numerator / denominator;
    }

    private void doSMthing() {
        long l = 12345678910L; //Если не указывать L литерал, то возникает ошибка Integer number to long.
//        Т.е. здесь нужно указывать, так как компилятор воспринимает число как интеджер.
        double d = 0.12345645; // здесь можно не указывать.
        float f = 0.12345645f; // Тут нужно указывать, иначе будет ошибка о несовместимости типов.



    }


}
