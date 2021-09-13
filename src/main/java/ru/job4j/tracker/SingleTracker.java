package ru.job4j.tracker;
import java.util.Arrays;

public final class SingleTracker {

    private Tracker tracker = new Tracker();
    private static SingleTracker checkCopy = null;
    private final Item[] items = new Item[100];
    private int size = 0;

    private SingleTracker() {
    }

    public static SingleTracker getCheckCopy() {
        if (checkCopy == null) {
            checkCopy = new SingleTracker();
        }
        return checkCopy;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
        }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}