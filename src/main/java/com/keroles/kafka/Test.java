package com.keroles.kafka;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        System.out.println("Consumer --------------------");
        Consumer<Integer> consumer = (so) -> {
            System.out.println(so);
            System.out.println("kero");
        };

        Predicate<String> predicate1 = (value) -> {
            System.out.println(value);
            System.out.println("predict1");
            return true;
        };
        Predicate<String> predicate2 = (value) -> {
            System.out.println(value);
            System.out.println("predict2");
            return true;
        };

        consumer.accept(1);
        System.out.println("Predicate --------------------");
        System.out.println(predicate1.and(predicate2)
                .test("dd"));
        ;
        BiFunction<Long, Long, String> biFunction = (aLong, aLong2) -> "keroles " + aLong + aLong2;
        biFunction.apply(1L, 1L);

        System.out.println("Function --------------------");
        Function<String, String> function1 = (s) -> "this is function1 " + s;
        Function<String, String> function2 = (s) -> "this is function2 " + s;

        Function<String, String> function3 = function1.andThen(function2);
        Thread longRunningThread = new Thread(() -> {
            System.out.println("Long running thread started");
            // Sleep for 5 seconds
            sleep(5000);
            System.out.println("Long running thread finished");
        });

        // Create second thread with shorter execution time
        Thread shortRunningThread = new Thread(() -> {
            System.out.println("Short running thread started");
            sleep(1000);
            System.out.println("Short running thread finished");
        });

        // Start both threads
        longRunningThread.start();
        shortRunningThread.start();

        // Wait for short thread to finish
        sleep(2000);
Thread.currentThread().getPriority();
        // Check if threads are alive
        boolean isLongThreadAlive = longRunningThread.isAlive();
        boolean isShortThreadAlive = shortRunningThread.isAlive();

        System.out.println("Long running thread is alive: " + isLongThreadAlive);   // true
        System.out.println("Short running thread is alive: " + isShortThreadAlive); // false
    }

    static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
