package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {



        CompletableFuture<String> part1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                System.out.println("error");
            }
            return "Hello... ";

        });
        String part3 = String.valueOf(part1);
        CompletableFuture<String> part2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "...world!";
        });





        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }

        BiFunction<String, String, String> function = (value, value2) -> combineFunctionality(value, value2);


        CompletableFuture<String> thenCombine = part1.thenCombine(part2, function);

        System.out.println("output: " + thenCombine.join());


    }
    public static String combineFunctionality(String input1, String input2) {
        System.out.println("part 1: " + input1);
        System.out.println("part 2: " + input2);

        return input1 + input2;

    }


}
