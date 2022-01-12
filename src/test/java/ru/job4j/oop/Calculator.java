package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int n) {
        return x - n;
    }

    public int divide (int n) {
        return n/x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        Calculator sumRsl = new Calculator();
        int rslMethods =  sum(4) + minus(4) + sumRsl.divide(4) + sumRsl.multiply(4) + sumRsl.sumAllOperation(4);
        System.out.println(rslMethods);
    }
}