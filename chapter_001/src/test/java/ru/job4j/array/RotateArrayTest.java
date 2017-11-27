package ru.job4j.array;

/**
 * Class RotateArrayTest тестирование поворота массива по часовой стрелке.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    @Test
    public void whenNotRotatedArrayThenRotetedArray() {
        RotateArray rotation = new RotateArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] resultArray = rotation.rotate(array);
        int[][] expectArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(resultArray, is(expectArray));
    }
	
	@Test
    public void whenNotRotatedArrayTwoOnTwoThenRotetedArray() {
        RotateArray rotation = new RotateArray();
        int[][] array = {{1, 2}, {3, 4}};
		int[][] resultArray = rotation.rotate(array);
        int[][] expectArray = {{3, 1}, {4, 2}};
        assertThat(resultArray, is(expectArray));
    }
}