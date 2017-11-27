package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class CounterTest 4.4. Тест построение пирамиды.
 * @author Shaev Andrey
 * @version 1.01
 * @since 18.11.17
*/
public class PaintTest {
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        final String line = System.getProperty("line.separator");
		String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^%s", line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint = new Paint();
        final String line = System.getProperty("line.separator");
		String result = paint.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", line, line, line);
        assertThat(result, is(expected));
    }
}