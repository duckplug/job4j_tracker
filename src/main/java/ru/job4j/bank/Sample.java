package ru.job4j.bank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
