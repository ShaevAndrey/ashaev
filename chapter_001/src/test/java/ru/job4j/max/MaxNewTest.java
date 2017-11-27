package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class MaxNewTest 3.4. Тест нахождения максимума из трёх чисел.
 * @author Shaev Andrey
 * @version 1.01
 * @since 18.11.17
*/
public class MaxNewTest {
@Test
public void whenFirstLessSecondLessTridr() {
    MaxNew maxim = new MaxNew();
    int result = maxim.maxNew(1, 2, 3);
    assertThat(result, is(3));
}
}