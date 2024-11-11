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
        CompletableFuture<String> part2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            return "...world!";
        });

        BiFunction<String, String, String> function = (value, value2) -> combineFunctionality(value, value2);

        CompletableFuture<String> thenCombineV = part1.thenCombine(part2, function);

        part1.thenAccept(c -> c += part2.join());

        System.out.println("OUTPUT: " + part1);


        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }





    }
/*
    public static String combineFunctionality(String input1, String input2) {
        System.out.println("part 1: " + input1);
        System.out.println("part 2: " + input2);

        return input1 + input2;

    }
*/


}
