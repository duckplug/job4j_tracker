package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.ItemCompareByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ItemCompareTest {

    @Test
    public void compareId() {
        List<Item> items = Arrays.asList(
                new Item(3, "Third"),
                new Item(1, "First"),
                new Item(2, "Second")
        );
        List<Item> streamlineId = Arrays.asList(
                new Item(1, "First"),
                new Item(2, "Second"),
                new Item(3, "Third")
        );
        List<Item> streamlineName = Arrays.asList(
                new Item(1, "First"),
                new Item(2, "Second"),
                new Item(3, "Third")
        );
        Collections.sort(items);
        assertThat(items, is(streamlineId));

    }

    @Test
    public void compareName() {
        List<Item> items = Arrays.asList(
                new Item(3, "Third"),
                new Item(1, "First"),
                new Item(2, "Second")
        );

        List<Item> streamlineName = Arrays.asList(
                new Item(1, "First"),
                new Item(2, "Second"),
                new Item(3, "Third")
        );
        Collections.sort(items, new ItemCompareByName());
        assertThat(items, is(streamlineName));
    }
}