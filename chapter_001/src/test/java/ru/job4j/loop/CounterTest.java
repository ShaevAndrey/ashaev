package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class CounterTest 4.1. Тест подсчёта чётных чисел в диапозоне
 * @author Shaev Andrey
 * @version 1.01
 * @since 18.11.17
*/
public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
       Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}