package ru.job4j.max;

/**
 * Class MaxNew 3.4. Определение максимума из трёх чисел.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
public class MaxNew {
	public int maxNew(int first, int second, int third) {
		return max(max(first, second), third);
	}
	public int max(int first, int second) {
		return first > second ? first : second;
	}
}