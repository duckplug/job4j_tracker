package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().
                getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items (name, created) "
                + "VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, timestampFromLDT);
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean check = false;
        try (PreparedStatement update = cn.prepareStatement("UPDATE items SET name = ?, created = ?"
                + " WHERE id = ?")) {
            update.setString(1, item.getName());
            update.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            update.setInt(3, id);
            check = update.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items WHERE id = ?")) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        String query = "SELECT * FROM items";
        try (Statement st = cn.createStatement()) {
            try (ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                Item item = new Item();
                item.setName(rs.getObject(2, String.class));
                item.setId(rs.getInt(1));
                item.setCreated(rs.getObject(3, Timestamp.class).toLocalDateTime());
                itemList.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            ps.setString(1, key);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                Item item = new Item();
                item.setName(rs.getObject(2, String.class));
                item.setId(rs.getInt(1));
                item.setCreated(rs.getObject(3, Timestamp.class).toLocalDateTime());
                itemList.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    item.setName(rs.getObject(2, String.class));
                    item.setId(rs.getInt(1));
                    item.setCreated(rs.getObject(3, Timestamp.class).toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}