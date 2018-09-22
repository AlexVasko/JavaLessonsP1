package com.javalesson.concurrency.waitnotify;


import static com.javalesson.concurrency.threadslesson.ColorScheme.BLUE;
import static com.javalesson.concurrency.threadslesson.ColorScheme.RED;

public class WaitNotifyExample {

    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();
    }

    private static class Producer implements Runnable {

        private final Message message;

        Producer(Message message) {
            this.message = message;
        }


        String[] text = {
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
            for (String t : text) {
                synchronized (message) {
                    System.out.println(BLUE + "Producing message: " + t);
                    message.setMessage(t);
                    message.notify();
                    if (!"DONE".equals(t)){
                        message.wait();
                    }
                }
                Thread.sleep(400);
            }
        }


    }

    private static class Consumer implements Runnable {

        private final Message message;

        Consumer(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            while (true){
                Thread.sleep(400);
                synchronized (message){
                    System.out.println(RED+"Consuming message: "+message.getMessage());
                    if(!"DONE".equals(message.getMessage())){
                        message.notify();
                        message.wait();
                    } else {
                        return;
                    }
                }
            }
        }

    }
}
