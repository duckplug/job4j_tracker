package ru.job4j.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        if (left.length() != right.length()) {
            rsl = Integer.compare(left.length(), right.length());
        } else {
            for (int i = 0; i < left.length(); i++) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                if (rsl != 0) {
                    break;
                }
            }
        }
        return rsl;
    }
}

