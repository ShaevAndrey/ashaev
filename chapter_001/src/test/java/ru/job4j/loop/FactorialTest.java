package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class CounterTest 4.2. Тест подсчёта факториала.
 * @author Shaev Andrey
 * @version 1.01
 * @since 18.11.17
*/
public class FactorialTest {
/**
 *тест факториала, число 5.
 */   
   @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
       Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
/**
 *тест факториала, число 0.
 */   
@Test
     public void whenCalculateFactorialForZeroThenOne() {
       Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}