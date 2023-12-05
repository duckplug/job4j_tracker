package ru.job4j.tracker.store;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }

        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item");
        Item item2 = new Item("item");
        List<Item> list = List.of(item1, item2);
        tracker.add(item1);
        tracker.add(item2);
        assertThatList(tracker.findByName("item")).containsSequence(list);
    }

    @Test
    public void whenNotFoundByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item");
        Item item2 = new Item("item");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("Other_item")).isEmpty();
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item");
        Item item2 = new Item("itemOther");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId())).isEqualTo(item1);
        assertThat(tracker.findById(item2.getId()).getId()).isEqualTo(item2.getId());
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item-1");
        Item item2 = new Item("item-2");
        Item item3 = new Item("item-3");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> list = new ArrayList();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertThatList(tracker.findAll()).containsSequence(list);
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }
    
    @Test
    public void whenReplaceAndFind() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Item");
        Item replaceItem = new Item( "ReplaceItem");
        List<Item> list = new ArrayList<>();
        list.add(item);
        tracker.add(item);
        tracker.add(replaceItem);
        tracker.replace(item.getId(), replaceItem);

        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replaceItem.getName());
        assertThatList(tracker.findAll()).containsSequence(list);
    }
}