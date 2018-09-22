package com.javalesson.concurrency.threadslesson;


import static com.javalesson.concurrency.threadslesson.ColorScheme.GREEN;
import static com.javalesson.concurrency.threadslesson.ColorScheme.YELLOW;

public class ConcurrentMain {

    public static void main(String[] args) {

        SimpleThread th1 = new SimpleThread();
        th1.start();


        SimpleThread th2 = new SimpleThread();
        th2.start();

        th2.interrupt();

        Thread th3 = new Thread(new SimpleRunner());
        th3.start();


        new Thread(()->
            System.out.println("Hello from Lambda Runnable")
        ).start();

        System.out.println("Hello from main");
    }


}

class SimpleThread extends Thread {

    @Override
    public void run() {

        for (int i=0; i<10; i++){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(YELLOW+"WARN - "+currentThread().getName()+" was interrupted ");
                return;
            }
            System.out.println(GREEN+"INFO - "+currentThread().getName()+" - "+i);
        }
    }
}


class SimpleRunner implements Runnable {


    @Override
    public void run() {
        for (int i=0; i<10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(YELLOW+"WARN - "+Thread.currentThread().getName()+" was interrupted ");
            }
            System.out.println(GREEN+"INFO - Runnable - "+Thread.currentThread().getName()+" - "+i);
        }
    }
}




