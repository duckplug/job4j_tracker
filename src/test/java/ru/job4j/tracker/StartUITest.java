package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.strategy.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();

        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find Me"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );


        UserAction[] actions = {
                new FindAllAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find all Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()+
                        "=== Show all items ====" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." +System.lineSeparator() +
                        "0. Find all Item" + System.lineSeparator() +
                        "1. Exit"+ System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find by name"));
        Input in = new StubInput(
                new String[]{"0", "Find by name", "1"}
        );


        UserAction[] actions = {
                new FindItemByNameAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find Item by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()+
                        "=== Find items by name ====" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." +System.lineSeparator() +
                        "0. Find Item by name" + System.lineSeparator() +
                        "1. Exit"+ System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIDAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find by id"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );


        UserAction[] actions = {
                new FindItemByIdAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find Item by ID" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()+
                        "=== Find item by id ====" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." +System.lineSeparator() +
                        "0. Find Item by ID" + System.lineSeparator() +
                        "1. Exit"+ System.lineSeparator()
        ));
    }
}
