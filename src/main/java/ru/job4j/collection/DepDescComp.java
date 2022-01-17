package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        ArrayList<String> str1 = new ArrayList<>(Arrays.asList(o1.split("/")));
        ArrayList<String> str2 = new ArrayList<>(Arrays.asList(o2.split("/")));
        int rsl;
            String s1 = str1.get(0);
            String s2 = str2.get(0);
            if (s1.compareTo(s2) == 0) {
                rsl = o1.compareTo(o2);
            } else {
                rsl = o2.compareTo(o1);
            }
        return rsl;
    }
}
