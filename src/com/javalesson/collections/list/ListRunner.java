package com.javalesson.collections.list;

import java.util.Scanner;

public class ListRunner {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        printOut();
        int param = scanner.nextInt();
        while (param != 0) {
            switch (param) {
                case 1:
                    System.out.println("Please enter a task to add");
                    scanner.nextLine();
                    String task1 = scanner.nextLine();
                    list.addToList(task1);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Printing out TO DO LIST");
                    list.printToDoList();
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Please enter a number of an item to update");
                    scanner.nextLine();
                    int index = scanner.nextInt();
                    System.out.println("Please enter a task name");
                    scanner.nextLine();
                    String task = scanner.nextLine();
                    list.changeTask(index, task);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Please enter a task name to remove");
                    scanner.nextLine();
                    String task4 = scanner.nextLine();
                    list.removeTask(task4);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Please enter the task to get number");
                    scanner.nextLine();
                    String task5 = scanner.nextLine();
                    System.out.println("Number of the task is "+list.getTaskPriority(task5));
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Please enter a number of position for the task");
                    scanner.nextLine();
                    int position = scanner.nextInt();
                    System.out.println("Please enter a task name");
                    scanner.nextLine();
                    String task6 = scanner.nextLine();
                    list.addToListAtPosition(position, task6);
                    System.out.println("Please choose an action by typing [0-6]");
                    param = scanner.nextInt();
                    break;
                default:
                    param = 0;
            }
        }


    }

    private static void printOut() {
        System.out.println("Please choose an action. Press :\n"
                + "1 to add a new item into ToDoList\n"
                + "2 to print out the list \n"
                + "3 to update an existing item\n"
                + "4 to remove an item form the list\n"
                + "5 to get task priority or number in the list\n"
                + "6 to add a new item at specific position\n"
                + "press 0 for exit\n\n"
                + "AFTER CHOOSING AN OPTION PLEASE PRESS ENTER");

// 1
// 10
// 11
// 100
// 1010
//        0101
    }
}
