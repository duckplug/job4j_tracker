package ru.job4j.strategy;

import ru.job4j.tracker.*;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find all Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Show all items ====");
        List<Item> items = store.findAll();
        if (items.isEmpty()) {
            out.println("Хранилище еще не содержи заявок.");
        } else {
            for (Item item : items) {
                out.println(item);
            }
        }
        return true;
    }
}
