package ru.job4j.array;

/**
 * Class BubbleSortTest тестирование сортировки массива.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenNotSortedArrayThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] array = {5, 1, 2, 7, 3};
		int[] resultArray = sort.sort(array);
        int[] expectArray = {1, 2, 3, 5, 7};
        assertThat(resultArray, is(expectArray));
    }
}