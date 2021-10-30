package ru.job4j.collection;

import java.util.Comparator;
import ru.job4j.tracker.Item;

public class ItemCompareByName implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
