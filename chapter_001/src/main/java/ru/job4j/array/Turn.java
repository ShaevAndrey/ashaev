package ru.job4j.array;

/**
 * Class Turn  служит для перевертывания массива.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 21.11.17.
*/
public class Turn {
public int[] back(int[] array) {
	int j = 0;
	for (int i = 0; i < array.length / 2; i++) {
		j = array[i];
		array[i] = array[(array.length - 1) - i];
		array[(array.length - 1) - i] = j;
		}
	return array;
	}
}