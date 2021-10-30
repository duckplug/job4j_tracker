package ru.job4j.collection;

import ru.job4j.tracker.Item;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class ItemCompare {
    public static void main(String[] args) {
        List<Item> itemsCompare = Arrays.asList(
                new Item(1, "Один"),
                new Item(3, "Три"),
                new Item(2, "Два")
        );
        System.out.println(itemsCompare);
        Collections.sort(itemsCompare);
        System.out.println(itemsCompare);
        Item

    }
}

