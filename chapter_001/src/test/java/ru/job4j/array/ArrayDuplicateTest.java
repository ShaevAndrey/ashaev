package ru.job4j.array;

/**
 * Class ArrayDuplicateTest тестирование удаления двойных элементов в массиве.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate test = new ArrayDuplicate();
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
		String[] resultArray = test.remove(array);
        String[] expectArray =  {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }
}