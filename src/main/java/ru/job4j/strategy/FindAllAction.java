package ru.job4j.strategy;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;
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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        List<Item> items = tracker.findAll();
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
