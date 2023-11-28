package com.solvd.GenericFunctions;

import java.util.function.Consumer;

public class GenericConsumerExample {
    public static void main(String[] args) {
        Consumer<Integer> printTwice = (num) -> {
            System.out.println("First print: " + num);
            System.out.println("Second print: " + num);
        };
        printTwice.accept(7);
    }
}