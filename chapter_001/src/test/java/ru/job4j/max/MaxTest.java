package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class MaxTest 3.1. Тест нахождения максимума издвух чисел.
 * @author Shaev Andrey
 * @version 1.01
 * @since 18.11.17
*/
public class MaxTest {
@Test
public void whenFirstLessSecond() {
    Max maxim = new Max();
    int result = maxim.max(1, 2);
    assertThat(result, is(2));
}
}