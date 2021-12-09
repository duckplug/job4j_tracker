package ru.job4j.function;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Order strings: " + left + " : " + right);
            return right.compareTo(left);
        };
    }
}
