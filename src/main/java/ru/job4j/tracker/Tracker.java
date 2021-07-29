package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemWithoutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                itemWithoutNull[size] = item;
                size += 1;
            }
        }
        itemWithoutNull = Arrays.copyOf(itemWithoutNull, size);
        return itemWithoutNull;
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] itemSameName = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if ((key.equals(item.getName()))) {
                itemSameName[size] = items[i];
                size += 1;
            }
        }
            itemSameName = Arrays.copyOf(itemSameName, size);
            return itemSameName;
        }
    }






