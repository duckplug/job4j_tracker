package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionNumTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionNum function = new FunctionNum();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqrtFunctionResults() {
        FunctionNum function = new FunctionNum();
        List<Double> result = function.diapason(1, 3, x -> 2 * Math.pow(x, 2) + x + 1);
        List<Double> expected = Arrays.asList(4D, 11D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionResults() {
        FunctionNum function = new FunctionNum();
        List<Double> result = function.diapason(1, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2.0, 4.0);
        assertThat(result, is(expected));
    }
}