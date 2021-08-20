package ru.job4j.strategy;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;
import static java.lang.System.out;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");

        }
        return true;
    }
}
