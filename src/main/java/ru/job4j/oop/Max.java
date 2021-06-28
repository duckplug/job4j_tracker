package ru.job4j.oop;

public class Max {

    public static int max(int left, int right) {
        return left >= right ? left : right;
    }

    public static int max(int left, int right, int one) {
        return max(max(left, right), one);
    }

    public static int max(int left, int right, int one, int two) {
        return max(max(left, right, one), two);
    }
}