package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (Item search : items) {
            if (search.getId() == id) {
                rsl = search;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item>  findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = items.indexOf(findById(id));
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
            for (Item searchId : items) {
                if (searchId.getId() == id) {
                    items.remove(searchId);
                    result = true;
                    break;
                }
            }
            return result;
    }
}






