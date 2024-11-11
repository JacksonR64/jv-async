package org.example;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                System.out.println("error");
                throw new RuntimeException(e);
            }
            System.out.println("Hello...");

        });
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("...world!");
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test");
    }

}
