package com.solvd.GenericFunctions;

import java.util.function.Function;

public class GenericFunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> convertToString = (num) -> String.valueOf(num);
        System.out.println(convertToString.apply(42)); // Output: "42"
     }
}
