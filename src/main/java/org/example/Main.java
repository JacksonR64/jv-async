package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {



        CompletableFuture<String> part1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                System.out.println("error");
            }
            return "Hello... ";

        });
        CompletableFuture<String> part2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("error");
            }
            return "...world!";
        });

        //BiFunction<String, String, String> function = (value, value2) -> combineFunctionality(value, value2);

        //CompletableFuture<String> thenCombineV = part1.thenCombine(part2, function);

        CompletableFuture<Void> output = part1.thenAccept(c -> System.out.println("Result: " + c + part2.join()));


        try {
            Thread.sleep(20000);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }





    }

//    public static String combineFunctionality(String input1, String input2) {
//        System.out.println("part 1: " + input1);
//        System.out.println("part 2: " + input2);
//
//        return input1 + input2;
//
//    }



}
