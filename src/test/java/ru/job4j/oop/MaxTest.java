package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;
public class MaxTest  {
    @Test
    public void testNumberThree() {
            int left = 2;
            int right = 1;
            int one = 5;
            int result = Max.max(left, right, one);
            int expected = 5;
            Assert.assertEquals(result, expected);
        }

    @Test
    public void testNumberFour() {
        int left = 2;
        int right = 1;
        int one = 5;
        int two = 9;
        int result = Max.max(left, right, one, two);
        int expected = 9;
        Assert.assertEquals(result, expected);
    }
}


