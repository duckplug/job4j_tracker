package ru.job4j.strategy;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    /**
     * Изменение метода
     */

    @Override
    public boolean execute(Input input, Store store) {
        int before = store.findAll().size();
        out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        store.delete(id);
        int after = store.findAll().size();
        if (before > after) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
