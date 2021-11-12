package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.collection.ItemAscByName;
import ru.job4j.collection.ItemDescByName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemCompareTest {

    @Test
    public void compareNameUp() {
        List<Item> items = Arrays.asList(
                new Item(3, "Third"),
                new Item(1, "First"),
                new Item(2, "Second")
        );

        List<Item> expected = Arrays.asList(
                new Item(1, "First"),
                new Item(2, "Second"),
                new Item(3, "Third")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }

    @Test
    public void compareNameDown() {
        List<Item> items = Arrays.asList(
                new Item(3, "Third"),
                new Item(1, "First"),
                new Item(2, "Second")
        );

        List<Item> expected = Arrays.asList(
                new Item(3, "Third"),
                new Item(2, "Second"),
                new Item(1, "First")

        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }
}