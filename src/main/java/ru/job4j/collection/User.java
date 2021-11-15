package ru.job4j.collection;

import ru.job4j.io.Matches;

import java.util.Collections;
import java.util.Objects;
import java.util.TreeSet;
import java.util.Set;
import java.util.TreeSet;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        return getName().compareTo(o.getName()) == 0?   Integer.compare(age, getAge()) : getName().compareTo(o.getName());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
