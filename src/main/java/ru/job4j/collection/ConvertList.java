package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] array:list) {
            for (int number:array) {
                rsl.add(number);
            }
        }
        return rsl;
    }
}
