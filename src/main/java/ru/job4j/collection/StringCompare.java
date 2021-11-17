package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int leng = left.length() >= right.length() ? left.length() : right.length();
        for (int i = 0; i < leng; i++) {
            if (Character.isDigit(left.charAt(i))) {
                rsl = Integer.compare(left.charAt(i), right.charAt(i));
            } else {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
            }
            if (rsl != 0) {
                break;
            }
        }
        return rsl;
    }
}
