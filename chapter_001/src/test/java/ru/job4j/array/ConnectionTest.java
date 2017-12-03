package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConnectionTest  Тестирует программу, котороая объединяет
 * два отсортированных массива втретий, сохраняя сортирвку.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 29.11.17.
 */
public class ConnectionTest {
    @Test
    public void whenConnectTwoSortArryaThenThirdConnectedArray() {
        Connection test = new Connection();
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {1, 1, 4, 7, 7, 9, 11, 15, 18};
        int[] resultArray = test.connection(array1, array2);
        int[] expectArray = {1, 1, 1, 3, 4, 5, 7, 7, 7, 9, 9, 11, 15, 18};
        assertThat(resultArray, is(expectArray));
    }
}
