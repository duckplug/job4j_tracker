package ru.job4j.collection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import ru.job4j.tracker.Item;

public class ItemCompareStr {
    public static void main(String[] args) {
        List<Item> itemsStr = Arrays.asList(
                new Item(1, "A"),
                new Item(2, "В"),
                new Item(1, "Б")
        );
        System.out.println(itemsStr);
        Collections.sort(itemsStr);
        System.out.println(itemsStr);
        Collections.sort(itemsStr, new ItemCompareByName());
        System.out.println(itemsStr);
    }

}
