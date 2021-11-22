package ru.job4j.collection;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;

import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenDescByPoint() {
        Comparator<Job> comparePointLow = new JobDescByPriority();
        int rsl = comparePointLow.compare(new Job("Work1", 99), new Job("Work2", 33));
        assertThat(rsl,lessThan(0));
    }

    @Test
    public void whenAscByPoint() {
        Comparator<Job> comparePointHigh = new JobAcsByPriority();
        int rsl = comparePointHigh.compare(new Job("Work1", 12), new Job("Work2", 10));
        assertThat(rsl,greaterThan(0));
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> compareNameLow = new JobDescByName();
        int rsl = compareNameLow.compare(new Job ("Work A", 22), new Job ("Work B", 77));
        assertThat(rsl,greaterThan(0));
    }

    @Test
    public void whenAcsByName() {
        Comparator<Job> compareNameHigh = new JobAcsByName();
        int rsl = compareNameHigh.compare(new Job ("Work A", 22), new Job ("Work B", 77));
        assertThat(rsl,lessThan(0));
    }

    @Test
    public void whenAcsByNameAndPriority() {
        Comparator<Job> compareNameHigh = new JobAcsByName().thenComparing(new JobAcsByPriority());
        int rsl = compareNameHigh.compare(new Job ("Work B", 2), new Job ("Work B", 1));
        assertThat(rsl,greaterThan(0));
    }

    @Test
    public void whenDescByNameDescPriority() {
        Comparator<Job> compareNameHigh = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = compareNameHigh.compare(new Job ("Work A", 1), new Job ("Work A", 2));
        assertThat(rsl,greaterThan(0));
    }
}