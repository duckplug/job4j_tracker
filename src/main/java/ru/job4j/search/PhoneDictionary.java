package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person same : persons) {
            if (same.getName().contains(key) || (same.getPhone().contains(key))
                    || (same.getSurname().contains(key)) || (same.getAddress().contains(key))) {
                result = persons;
            }
        }
        return result;
    }
}