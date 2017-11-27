package ru.job4j.array;

/**
 * Class TurnTest тестирование перевертывания матрицы.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4};
		int[] result = turn.back(array);
        int[] expected = {4, 3, 2, 1};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
       Turn turn = new Turn();
        int[] array = {1, 2, 3};
		int[] result = turn.back(array);
        int[] expected = {3, 2, 1};
        assertThat(result, is(expected));
    }
}