package ru.job4j.tracker;
import java.util.List;

public final class SingleTracker {

    private static SingleTracker checkCopy = null;
    private Store store = new SqlTracker();

    private SingleTracker() {

    }

    public static SingleTracker getCheckCopy() {
        if (checkCopy == null) {
            checkCopy = new SingleTracker();
        }
        return checkCopy;
    }

    public Item add(Item item) {
        return store.add(item);
    }

    public Item findById(int id) {
        return store.findById(id);
    }

    public List<Item> findAll() {
        return store.findAll();
    }

    public List<Item> findByName(String key) {
        return store.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return store.replace(id, item);
    }

    public void delete(int id) {
        store.delete(id);
    }
}