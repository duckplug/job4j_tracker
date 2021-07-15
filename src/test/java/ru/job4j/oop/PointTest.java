package ru.job4j.oop;

import org.junit.Test;

import org.junit.Assert;

public class PointTest {
    @Test
    public void when000to000then0() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(0,0,0);
        double dist = first.distance(second);
        double expected = 0.0;
        Assert.assertEquals(expected, dist, 0.001);

    }

    @Test
    public void when000to111then0() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(1,1,1);
        double dist = first.distance(second);
        double expected = 1.414;
        Assert.assertEquals(expected, dist, 0.001);
    }
}


