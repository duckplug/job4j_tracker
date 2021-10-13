package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;
    //private int size = 0;

    public Item add(Item item) {
        items.add(item);
       // item.setId(ids++);
        //items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        return items.get(id);
        //int index = indexOf(id);
        //return index != -1 ? items[index] : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item findByName(String key) {
        Item rsl = null;
        for (Item ex: items) {
            if (key.equals(ex.getName())) {
                rsl = ex;
            }
        }
        return rsl;
    }

//    private int indexOf(int id) {
//        int rsl = -1;
//        for (int index = 0; index < size; index++) {
//            if (items[index].getId() == id) {
//                rsl = index;
//                break;
//            }
//        }
//        return rsl;
//    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        for (Item searchId : items) {
            if (searchId.getId() == id) {
                searchId = item;
                result = true;
            }
        }
        return result;
    }

            //        int index = indexOf(id);
//        boolean result = index != -1;
//        if (result) {
//            item.setId(id);
//            items[index] = item;
//        }
//        return result;
//    }

    public boolean delete(int id) {
            boolean result = false;
            for (Item searchId : items) {
                if (searchId.getId() == id) {
                    items.remove(searchId);
                }
            }
            return result;
        }
}






