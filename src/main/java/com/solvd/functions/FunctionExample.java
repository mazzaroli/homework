package com.solvd.functions;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> intToString = num -> "Number: " + num;
        System.out.println(intToString.apply(42)); // Output: Number: 42
    }
}