package com.solvd.GenericFunctions;

import java.util.function.Predicate;

public class GenericPredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = (num) -> num > 0;
        System.out.println(isPositive.test(5)); // Output: true

        Predicate<String> isNotEmpty = (str) -> !str.isEmpty();
        System.out.println(isNotEmpty.test("Hello")); // Output: true
    }
}