package ru.job4j.array;

/**
 * Class BubbleSort  служит для сортировки массива.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 21.11.17.
*/
public class BubbleSort {
	public int[] sort(int[] sort) {
		int k;
		do {
			k = 0;
			int buffer = 0;
			for (int i = 0; i < sort.length - 1; i++) {
				if (sort[i] > sort[i + 1]) {
					k++;
					buffer = sort[i + 1];
					sort[i + 1] = sort[i];
					sort[i] = buffer;
				}
			}
		} while (k != 0);
	return sort;
	}
}