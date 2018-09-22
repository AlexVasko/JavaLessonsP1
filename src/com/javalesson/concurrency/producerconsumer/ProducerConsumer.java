package com.javalesson.concurrency.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.javalesson.concurrency.threadslesson.ColorScheme.GREEN;
import static com.javalesson.concurrency.threadslesson.ColorScheme.RED;

public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();

    }

    private static class Producer implements Runnable{
        String[] messages = {
                "Whose woods these are I think I know.",
                "His house is in the village, though;",
                "He will not see me stopping here",
                "To watch his woods fill up with snow.",
                "My little horse must think it queer",
                "To stop without a farmhouse near",
                "Between the woods and frozen lake",
                "The darkest evening of the year.",
                "He gives his harness bells a shake",
                "To ask if there is some mistake.",
                "The only other sound's the sweep",
                "Of easy wind and downy flake.",
                "The woods are lovely, dark and deep,",
                "But I have promises to keep,",
                "And miles to go before I sleep,",
                "And miles to go before I sleep.",
                "DONE"

        };

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            Random r = new Random();
            for(int i=0; i<messages.length; i++){
                queue.put(messages[i]);
                System.out.println(GREEN+"Producing "+messages[i]+ ". Queue size is "+queue.size());
                Thread.sleep(r.nextInt(2000));
            }
        }
    }

    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            Random r = new Random();
            while (true){
                String message = queue.take();
                System.out.println(RED+"Consuming "+message+" Que size is "+queue.size());
                if(!"DONE".equals(message)){
                    Thread.sleep(r.nextInt(1000));
                } else {
                    return;
                }

            }
        }
    }
}
